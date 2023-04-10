package com.pilifenghuolang.ISS.schedule;

import com.pilifenghuolang.ISS.domain.Stuff;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class CreateSchedule {


    //传入开始时间+每小时人流量，返回一个排好的待填空的排班表
    public static ArrayList<Time> schedulingStep1(String dayOfTheWeek, Integer shopStartTime, ArrayList<Integer> stuffNeedArr){

        ArrayList<Time> scheduleArr=new ArrayList<>();

        for(int i=0; i<stuffNeedArr.size(); i++){

            int stuffHave=0;
            int stuffNeed=stuffNeedArr.get(i);
            int hour=shopStartTime+i;//需要员工数 对应的那个小时

            for(Time time:scheduleArr){//把本小时已经存在的have记录下来
                if((time.getStartTime() <= hour)&&(hour + 1 <= time.getEndTime())){
                    stuffHave++;
                }
            }

            if(stuffHave < stuffNeed){//如果已存在的不够
                for(Time time:scheduleArr){//把能延长先延长一小时
                    if((time.getEndTime()-time.getStartTime()<4) && (time.getEndTime()==hour)){
                        time.setEndTime(time.getEndTime()+1);
                        stuffHave++;
                    }

                    if(stuffHave == stuffNeed) break;
                }
                while(stuffHave < stuffNeed){//还不够的话那就加入新的time
                    Time time=new Time(hour,hour+2,dayOfTheWeek);
                    scheduleArr.add(time);
                    stuffHave++;
                }//直到够了为止
            }

            int count=0;
            for(Time time : scheduleArr){
                if(time.getEndTime()>24){
                    int pushForwardNum=time.getEndTime()-24;
                    Time replaceTime=new Time(time.getStartTime()-pushForwardNum,time.getEndTime()-pushForwardNum,dayOfTheWeek);
                    scheduleArr.set(count,replaceTime);
                }
                count++;
            }

        }

        return scheduleArr;
    }



    //输入排好的待填空的排班表+员工数组的成员变量进行赋值
    public static LinkedHashMap<Time, Stuff> schedulingStep2(ArrayList<Time> scheduleArr, ArrayList<Stuff> stuffArr){

        LinkedHashMap<Time,Stuff> timeStuffMap=new LinkedHashMap<>();//最终time和stuff的映射关系全放在这个map中

        for(Time time:scheduleArr){//遍历待填入的时间段

//            System.out.println(time);

            Integer preferenceMaxValue=-1; //只有大于等于0的才可以第一次被替换
            int count=1;
            double replaceProbability = 1.0/(count+1);
            Random r = new Random();

            for(Stuff stuff:stuffArr){

                Integer preferenceValue;
                if(stuff.isOverTime(time)||stuff.isRestTime(time)){
                    preferenceValue=-1;
                }else{
                    preferenceValue=stuff.getPreferenceValue(time);
                }

                if(preferenceValue == preferenceMaxValue && preferenceMaxValue!=-1){
                    if(stuff.getPersonalWorkingHours().get(1) < timeStuffMap.get(time).getPersonalWorkingHours().get(1)){
                        count=1;
                        replaceProbability = 1.0/(count+1);
                        timeStuffMap.put(time,stuff);
                    }else if(stuff.getPersonalWorkingHours().get(1) == timeStuffMap.get(time).getPersonalWorkingHours().get(1)){
                        if(replaceProbability > r.nextDouble()){
                            timeStuffMap.put(time,stuff);
                        }
                        count++;
                        replaceProbability = 1.0/(count+1);
                    }
                }

                if(preferenceValue > preferenceMaxValue){
                    timeStuffMap.put(time,stuff);
                    preferenceMaxValue=preferenceValue;

                    count=1;
                    replaceProbability = 1.0/(count+1);
                }

            }//选择完这个time对应的stuff之后，对stuff的status进行改变
            // 1.日工作时间和周工作时间进行更新
            // 2.如果是4小时或者覆盖午饭晚饭时间，则对休息时间进行更新
            // 3.将该time添加到个人的时间表中（成员变量）

            Stuff stuff=timeStuffMap.get(time);

            if(stuff!=null){
                stuff.updateOfWorkingHours(time);//日/周工作时间更新

                if(Time.isFourHourTime(time)){//判断是否要加入休息时间
                    stuff.addRestTime(time);
                }else if(Time.isCoverLunchTime(time)){
                    stuff.addRestTime(time);
                }else if (Time.isCoverDinnerTime(time)) {
                    stuff.addRestTime(time);
                }

                stuff.addScheduleTime(time);//将该时间段time加入到个人的时间表中
            }else{
                stuff=new Stuff("待填入");
                timeStuffMap.put(time,stuff);
            }


//            System.out.println(stuff);


            //timeStuffMap在上面已经装配好了

        }

        return timeStuffMap;

    }

}

package com.pilifenghuolang.ISS.schedule;

import com.pilifenghuolang.ISS.Stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScheduleStep2 {

    public ScheduleStep2() {
    }


    //输入排好的待填空的排班表+员工数组的成员变量进行赋值
    public static Map<Time,Stuff> scheduling(ArrayList<Time> scheduleArr, ArrayList<Stuff> stuffArr){

        Map<Time,Stuff> timeStuffMap=new LinkedHashMap<Time,Stuff>();//最终time和stuff的映射关系全放在这个map中

        for(Time time:scheduleArr){//遍历待填入的时间段

            Integer preferenceMaxValue=-1; //只有大于等于0的才可以第一次被替换
            for(Stuff stuff:stuffArr){
                Integer preferenceValue;
                if(stuff.isOverTime(time)||stuff.isRestTime(time)){
                    preferenceValue=-1;
                }else{
                    preferenceValue=stuff.getPreferenceValue(time);
                }

                if(preferenceValue > preferenceMaxValue){
                    timeStuffMap.put(time,stuff);
                    preferenceMaxValue=preferenceValue;
                }
            }//选择完这个time对应的stuff之后，对stuff的status进行改变
            // 1.日工作时间和周工作时间进行更新
            // 2.如果是4小时或者覆盖午饭晚饭时间，则对休息时间进行更新
            // 3.将该time添加到个人的时间表中（成员变量）

            Stuff stuff=timeStuffMap.get(time);

            stuff.updateOfWorkingHours(time);//日/周工作时间更新

            if(Time.isFourHourTime(time)){//判断是否要加入休息时间
                stuff.addRestTime(time);
            }else if(Time.isCoverLunchTime(time)){
                stuff.addRestTime(time);
            }else if (Time.isCoverDinnerTime(time)) {
                stuff.addRestTime(time);
            }

            stuff.addScheduleTime(time);//将该时间段time加入到个人的时间表中



        }

        return timeStuffMap;

    }
}

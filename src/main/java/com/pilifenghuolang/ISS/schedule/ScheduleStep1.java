package com.pilifenghuolang.ISS.schedule;

import java.util.ArrayList;

public class ScheduleStep1 {



    //传入开始时间+每小时人流量，返回一个排好的待填空的排班表
    public static ArrayList<Time> scheduling(String dayOfTheWeek,Integer shopStartTime,ArrayList<Integer> assistantNeedArr){

        ArrayList<Time> scheduleArr=new ArrayList<Time>();

        for(int i=0; i<assistantNeedArr.size(); i++){

            int assistantHave=0;
            int assistantNeed=assistantNeedArr.get(i);
            int hour=shopStartTime+i;//需要员工数 对应的那个小时

            for(Time time:scheduleArr){//把本小时已经存在的have记录下来
                if((time.getStartTime() <= hour)&&(hour + 1 <= time.getEndTime())){
                    assistantHave++;
                }
            }

            if(assistantHave < assistantNeed){//如果已存在的不够
                for(Time time:scheduleArr){//把能延长先延长一小时
                    if((time.getEndTime()-time.getStartTime()<4) && (time.getEndTime()==hour)){
                        time.setEndTime(time.getEndTime()+1);
                        assistantHave++;
                    }

                    if(assistantHave == assistantNeed) break;
                }
                while(assistantHave < assistantNeed){//还不够的话那就加入新的time
                    Time time=new Time(hour,hour+2,dayOfTheWeek);
                    scheduleArr.add(time);
                    assistantHave++;
                }//直到够了为止
            }

        }

        return scheduleArr;
    }

}

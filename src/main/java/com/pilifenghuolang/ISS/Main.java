package com.pilifenghuolang.ISS;

import com.pilifenghuolang.ISS.schedule.CreateBasicData;
import com.pilifenghuolang.ISS.schedule.Schedule;
import com.pilifenghuolang.ISS.schedule.Time;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {

//        Integer shopStart=7;
//        Integer[] assNeedArray={2, 1, 2, 4, 5, 6, 7, 5, 5, 4, 3, 2, 1, 1, 4};
//        ArrayList<Integer> assNeedArr=new ArrayList<Integer>();
//        for(Integer n:assNeedArray){
//            assNeedArr.add(n);
//        }
//
//        ArrayList<Time> scheduleArr=new ScheduleStep1().scheduling(shopStart,assNeedArr);
//
//        for(Time time : scheduleArr){
//            System.out.println(time);
//        }


//        Time time1=new Time(1,2);
//        Time time2=new Time(3,4);
//
//        Time temp=time1;
//        time1=time2;
//        time2=temp;
//
//        temp.setEndTime(5);
//
//        System.out.println(time1);
//        System.out.println(time2);
//        System.out.println(temp);


//        Time time1=new Time(3,7);
//        Time time2=new Time(3,5);
//        System.out.println(Time.timeOverlapNum(time1,time2));
//
//        time1=new Time(3,5);
//        time2=new Time(3,7);
//        System.out.println(Time.timeOverlapNum(time1,time2));
//
//        time1=new Time(3,7);
//        time2=new Time(5,9);
//        System.out.println(Time.timeOverlapNum(time1,time2));
//
//        time1=new Time(5,9);
//        time2=new Time(3,7);
//        System.out.println(Time.timeOverlapNum(time1,time2));
//
//        time1=new Time(3,7);
//        time2=new Time(8,11);
//        System.out.println(Time.timeOverlapNum(time1,time2));
//
//        time1=new Time(5,8);
//        time2=new Time(4,9);
//        System.out.println(Time.timeOverlapNum(time1,time2));

        Store store=new Store();
        store.setStuffArr(CreateBasicData.createStuffArr());
        LinkedHashMap<String, LinkedHashMap<Time, Stuff>> timeStuffWeekMap = store.intelligentScheduling(CreateBasicData.passFlowNumWeekMap());
        store.showStuffArrSchedule();
//
//        for(String dayOfTheWeek : timeStuffWeekMap.keySet()){
//            System.out.println("zhou"+dayOfTheWeek);
//            for(Time time : timeStuffWeekMap.get(dayOfTheWeek).keySet()){
//                System.out.print(time + ":" + timeStuffWeekMap.get(dayOfTheWeek).get(time));
//            }
//        }
//
//        System.out.println(timeStuffWeekMap);

        //System.out.println(CreateBasicData.createStuffArr());
//
//        System.out.println(CreateBasicData.passFlowNumWeekMap());


        //输出1.客流量模拟
        //2.员工需求量
        //3.生成的空的排班表
//        Store store=new Store();
//        System.out.println(CreateBasicData.passFlowNumWeekMap());
//        LinkedHashMap<String, ArrayList<Integer>> stuffNeedWeekArr=store.getStuffNeedWeekArr(CreateBasicData.passFlowNumWeekMap());
//        System.out.println(stuffNeedWeekArr);
//
//        for(String dayOfTheWeek:stuffNeedWeekArr.keySet()){
//            System.out.println(Schedule.schedulingStep1(dayOfTheWeek,store.getShopStartTime(dayOfTheWeek),stuffNeedWeekArr.get(dayOfTheWeek)));
//        }

    }



}

package com.pilifenghuolang.ISS;

import com.pilifenghuolang.ISS.schedule.Time;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Stuff {

    //用于展示的数据
    private String name;//员工名字
    private String position;//职位
    private String telephone;//电话号码
    private String mail;//电子邮箱
    private String stores;//所属门店
    private ArrayList<Integer> preferenceArr;//描述偏好的数组，0-6是周一到周日，7-18是早九到晚九，19到30是早十到晚十，31是日工作最长时间，32是周最长工作时间
    private LinkedHashMap<Integer,ArrayList<Time>> preferenceMap;//0对应的是星期几的偏好数组，1代表的是时间段的偏好数组，2代表的是日最长工作时间，3代表的是周工作最长时间

    private ArrayList<Time> personalSchedule;//用于存放个人的排班时间段
    private ArrayList<Integer> personalWorkingHours;//0代表日工作时间，1代表周工作时间
    private ArrayList<Time> personalRestTime;//用于存放休息的时间段


    //加入i小时之后，是否造成超过日上限或周上限
    public boolean isOverTime(Time time){
        boolean flag=true;
        int hourNum=time.getTimeNum();
        if(personalWorkingHours.get(0) + hourNum > preferenceMap.get(2).get(0).getTimeNum()
        ||personalWorkingHours.get(1) + hourNum >preferenceMap.get(3).get(0).getTimeNum()){
            flag=false;
        }
        return flag;
    }


    //输入的time是否和personalRestTime的时间有重叠（星期几相同和时间段重叠才算）
    public boolean isRestTime(Time time){
        boolean flag=true;
        for(Time restTime:personalRestTime){
            if(Time.isDayOfTheWeekEqual(time,restTime)&&Time.timeOverlapNum(time,restTime)>0){
                flag=false;
            }
        }

        return flag;
    }


    //输入time与preferenceMap的星期偏好和时间段偏好比较，获取preferenceValue的值
    public Integer getPreferenceValue(Time time){

        //星期偏好如果存在，则weekPreferenceValue的值设置成2，如果不存在则默认为1
        Integer weekPreferenceValue=1;
        for(Time weekPreferenceTime:preferenceMap.get(0)){
            if(time.getDayOfTheWeek()==weekPreferenceTime.getDayOfTheWeek()) weekPreferenceValue=2;
        }

        Integer timeOverlapNumMax=0;
        for(Time timePeriodPreference:preferenceMap.get(1)){
            if(Time.timeOverlapNum(time,timePeriodPreference)>timeOverlapNumMax) timeOverlapNumMax=Time.timeOverlapNum(time,timePeriodPreference);
        }

        return weekPreferenceValue * timeOverlapNumMax;
    }
    
    
    //输入一个time，对周工作时间和日工作时间进行更新
    public void updateOfWorkingHours(Time time){
        personalWorkingHours.set(0,personalWorkingHours.get(0)+time.getTimeNum());
        personalWorkingHours.set(1,personalWorkingHours.get(1)+time.getTimeNum());
    }


    //添加一个一小时的时间段（在输入time的末尾时间 作为restTime的起点）
    public void addRestTime(Time time){

        Time restTime=new Time(time.getEndTime(),time.getEndTime()+1,time.getDayOfTheWeek());//周几也要知道
        personalRestTime.add(restTime);

    }


    public void addScheduleTime(Time time){

        personalSchedule.add(time);

    }

}

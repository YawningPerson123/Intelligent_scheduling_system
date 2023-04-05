package com.pilifenghuolang.ISS.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.pilifenghuolang.ISS.schedule.Time;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

@Data
public class Stuff {
    //数据库中用来查询的数据
    private Integer id;
    //用于展示的数据
    private String name;//员工名字
    private String position;//职位
    private String telephone;//电话号码
    private String mail;//电子邮箱
    private String stores;//所属门店
    @TableField(exist = false)
    private LinkedHashMap<Integer,ArrayList<Time>> preferenceMap=new LinkedHashMap<>();//0对应的是星期几的偏好数组，1代表的是时间段的偏好数组，2代表的是日最长工作时间，3代表的是周工作最长时间
    private Integer dayWorkingTimeUpperLimit=8;
    private Integer weekWorkingTimeUpperLimit=40;

    @TableField(exist = false)
    private ArrayList<Time> personalSchedule=new ArrayList<>();//用于存放个人的排班时间段
    //private ArrayList<Integer> personalWorkingHours=new ArrayList<>();//0代表日工作时间，1代表周工作时间
    @TableField(exist = false)
    private LinkedHashMap<Integer,Integer> personalWorkingHours=new LinkedHashMap<Integer,Integer>(){{put(0,0);put(1,0);}};//0代表日工作时间，1代表周工作时间
    @TableField(exist = false)
    private ArrayList<Time> personalRestTime=new ArrayList<>();//用于存放休息的时间段

    public Stuff(String name) {
        this.name=name;
    }

    public Stuff(Integer id, String name, String position, String telephone, String mail, String stores, Integer dayWorkingTimeUpperLimit, Integer weekWorkingTimeUpperLimit) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.telephone = telephone;
        this.mail = mail;
        this.stores = stores;
        this.dayWorkingTimeUpperLimit = dayWorkingTimeUpperLimit;
        this.weekWorkingTimeUpperLimit = weekWorkingTimeUpperLimit;
    }

    public void setWorkingTimeUpperLimit(Integer dayWorkingTimeUpperLimit, Integer weekWorkingTimeUpperLimit){
        this.dayWorkingTimeUpperLimit=dayWorkingTimeUpperLimit;
        this.weekWorkingTimeUpperLimit=weekWorkingTimeUpperLimit;
    }

    public void setPreferenceMap(LinkedHashMap<Integer,ArrayList<Time>> preferenceMap){
        this.preferenceMap=preferenceMap;
    }
    @Override
    public String toString() {
        return "Stuff{" +
                "name='" + name + '\'' +
                '}';
    }

    //加入i小时之后，是否造成超过日上限或周上限
    public boolean isOverTime(Time time){
        boolean flag=false;
        int hourNum=time.getTimeNum();
        if(personalWorkingHours.get(0) + hourNum > dayWorkingTimeUpperLimit
        ||personalWorkingHours.get(1) + hourNum > weekWorkingTimeUpperLimit){
            flag=true;
        }

//        System.out.println(personalWorkingHours.get(0) + hourNum);
//        System.out.println(dayWorkingTimeUpperLimit);
//        System.out.println(personalWorkingHours.get(1) + hourNum);
//        System.out.println(weekWorkingTimeUpperLimit);

        return flag;
    }


    //输入的time是否和personalRestTime的时间有重叠（星期几相同和时间段重叠才算）
    public boolean isRestTime(Time time){
        boolean flag=false;
        if(personalRestTime.size()!=0){
            for(Time restTime:personalRestTime){
                if(Time.isDayOfTheWeekEqual(time,restTime)&&Time.timeOverlapNum(time,restTime)>0){
                    flag=true;
                }
            }
        }

        return flag;
    }


    //输入time与preferenceMap的星期偏好和时间段偏好比较，获取preferenceValue的值
    public Integer getPreferenceValue(Time time){

        //星期偏好如果存在，则weekPreferenceValue的值设置成2，如果不存在则默认为1
        Integer weekPreferenceValue=1;
        if(preferenceMap.get(0)!=null){
            for(Time weekPreferenceTime:preferenceMap.get(0)){
                if(time.getDayOfTheWeek().equals(weekPreferenceTime.getDayOfTheWeek())) weekPreferenceValue=2;
            }
        }

        Integer timeOverlapNumMax=0;
        if(preferenceMap.get(1)!=null){
            for(Time timePeriodPreference:preferenceMap.get(1)){
                if(Time.timeOverlapNum(time,timePeriodPreference)>timeOverlapNumMax) timeOverlapNumMax=Time.timeOverlapNum(time,timePeriodPreference);
            }
        }

        return weekPreferenceValue * timeOverlapNumMax;
    }
    
    
    //输入一个time，对周工作时间和日工作时间进行更新
    public void updateOfWorkingHours(Time time){
        personalWorkingHours.put(0,personalWorkingHours.get(0)+time.getTimeNum());
        personalWorkingHours.put(1,personalWorkingHours.get(1)+time.getTimeNum());
    }


    //添加一个一小时的时间段（在输入time的末尾时间 作为restTime的起点）
    public void addRestTime(Time time){

        Time restTime=new Time(time.getEndTime(),time.getEndTime()+1,time.getDayOfTheWeek());//周几也要知道
        personalRestTime.add(restTime);

    }


    public void addScheduleTime(Time time){

        personalSchedule.add(time);

    }


    public void setPersonalDayWorkingHoursReturnToZero(){
        personalWorkingHours.put(0,0);
    }

    public void showPersonalSchedule(){
        if(personalSchedule!=null){
            System.out.print(name+":  ");
            System.out.print("personalWorkingHours:" + personalWorkingHours.get(1) +"  ");
            for(Time time:personalSchedule){
                System.out.print(time);
            }
            System.out.println();
        }
    }
}

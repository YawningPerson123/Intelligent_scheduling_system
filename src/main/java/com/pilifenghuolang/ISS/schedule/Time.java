package com.pilifenghuolang.ISS.schedule;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("preference")
public class Time {
    //数据库中用来查询的数据
    @TableId(type= IdType.AUTO)
    private Integer id;
    private Integer stuffId;
    private Integer type;

    private Integer startTime;
    private Integer endTime;
    private String dayOfTheWeek;//周几,为了构造函数和timeNum区分而选用String

    @TableField(exist = false)
    private Integer timeNum;//时间段的数值

    public Time(Integer startTime, Integer endTime, String dayOfTheWeek, Integer timeNum) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfTheWeek = dayOfTheWeek;
        this.timeNum = timeNum;
    }

    public Integer getId() {
        return id;
    }

    public Integer getStuffId() {
        return stuffId;
    }

    public Integer getType() {
        return type;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setStuffId(Integer stuffId) {
        this.stuffId = stuffId;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    //如果有头时间和尾时间，则相减之后在返回
    //如果是单纯设置时间大小的，则直接返回
    public Integer getTimeNum() {
        if(this.getStartTime()!=null&&this.getStartTime()!=0&&this.getEndTime()!=null&&this.getEndTime()!=0){
            timeNum=this.getEndTime()-this.getStartTime();
        }
        return timeNum;
    }


    public Time() {
    }

    public Time(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }


    public Time(Integer startTime, Integer endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Time(Integer startTime, Integer endTime, String dayOfTheWeek) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public Time(Integer stuffId, String dayOfTheWeek) {
        this.stuffId = stuffId;
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public Time(Integer stuffId, Integer startTime, Integer endTime) {
        this.stuffId = stuffId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Time(Integer id, Integer stuff_id, Integer type, Integer startTime, Integer endTime, String dayOfTheWeek) {
        this.id = id;
        this.stuffId = stuff_id;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfTheWeek = dayOfTheWeek;
    }


    //判断两个time的星期几是否相等
    public static boolean isDayOfTheWeekEqual(Time time1,Time time2){
        boolean flag=true;
        if(!time1.getDayOfTheWeek().equals(time2.getDayOfTheWeek())) flag=false;

        return flag;
    }

    //获得两个time时间重叠的数值（不在乎星期几是否相同）
    public static Integer timeOverlapNum(Time time1,Time time2){
        Integer num=0;

        if(time1.getStartTime()>time2.getStartTime()){
            Time temp=time1;
            time1=time2;
            time2=temp;
        }

        if(time1.getEndTime()<=time2.getStartTime()){
            num=0;
        } else if (time1.getStartTime()==time2.getStartTime()) {
            if(time1.getEndTime()<=time2.getEndTime()){
                num=time1.getTimeNum();
            }else{
                num=time2.getTimeNum();
            }
        } else if (time1.getEndTime()>= time2.getEndTime()) {
            num=time2.getTimeNum();
        }else{
            num=time1.getEndTime()-time2.getStartTime();
        }

        return num;
    }


    //判断输入的time是否完全覆盖lunchTime
    public static boolean isCoverLunchTime(Time time){

        boolean flag=false;
        Time lunchTime=new Time(11,14);
        if(Time.timeOverlapNum(time,lunchTime)==0) flag=true;

        return flag;
    }


    public static boolean isCoverDinnerTime(Time time){

        boolean flag=false;
        Time dinnerTime=new Time(17,20);
        if(Time.timeOverlapNum(time,dinnerTime)==0) flag=true;

        return flag;
    }


    public static boolean isFourHourTime(Time time){

        boolean flag=false;
        if(time.timeNum==4) flag=true;

        return flag;
    }


    @Override
    public String toString() {
        return "Time{" +
                "stuff_id=" + stuffId +
                ", type=" + type +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", dayOfTheWeek='" + dayOfTheWeek + '\'' +
                '}';
    }
}

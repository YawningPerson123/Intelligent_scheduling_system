package com.pilifenghuolang.ISS.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

@TableName("schedule")
public class Schedule{
    /** 主键 */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /** 那一周 */
    private Integer weekId ;
    /** 星期 */
    private String dayOfWeek ;
    /** 日期 */
    private Date date ;
    /** 员工id */
    private Integer stuffId ;
    /** 开始时间 */
    private Integer startTime ;
    /** 结束时间 */
    private Integer endTime ;

    /** 主键 */
    public Integer getId(){
        return this.id;
    }
    /** 主键 */
    public void setId(Integer id){
        this.id=id;
    }
    /** 哪一周 */
    public Integer getWeekId(){
        return this.weekId;
    }
    /** 哪一周 */
    public void setWeekId(Integer weekId){
        this.weekId=weekId;
    }
    /** 星期 */
    public String getDayOfWeek(){
        return this.dayOfWeek;
    }
    /** 星期 */
    public void setDayOfWeek(String dayOfWeek){
        this.dayOfWeek=dayOfWeek;
    }
    /** 日期 */
    public Date getDate(){
        return this.date;
    }
    /** 日期 */
    public void setDate(Date date){
        this.date=date;
    }
    /** 员工id */
    public Integer getStuffId(){
        return this.stuffId;
    }
    /** 员工id */
    public void setStuffId(Integer stuffId){
        this.stuffId=stuffId;
    }
    /** 开始时间 */
    public Integer getStartTime(){
        return this.startTime;
    }
    /** 开始时间 */
    public void setStartTime(Integer startTime){
        this.startTime=startTime;
    }
    /** 结束时间 */
    public Integer getEndTime(){
        return this.endTime;
    }
    /** 结束时间 */
    public void setEndTime(Integer endTime){
        this.endTime=endTime;
    }
}
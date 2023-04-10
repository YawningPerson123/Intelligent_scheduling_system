package com.pilifenghuolang.ISS.service;

import com.pilifenghuolang.ISS.domain.Schedule;
import com.pilifenghuolang.ISS.domain.Stuff;

import java.util.Date;
import java.util.List;

public interface ScheduleService {

    boolean save(Schedule schedule);

    boolean update(Schedule schedule);

    /**
     * 获取一个员工某一周的工作时间
     * @param stuffId
     * @param weekId
     * @return
     */
    List<Schedule> getOneWeekByStuffId(Integer stuffId, Integer weekId);

    /**
     * 获取某一天的所有排班
     * @param date
     * @return
     */
    List<Schedule> getOneDay(Date date);

    /**
     * 初始化客流量
     * @return
     */
    boolean initPassFlow();

    /**
     * 初始化排班表
     * @return
     */
    boolean initSchedule();

    /**
     * 删除所有客流数据
     * @return
     */
    boolean deletePassFlow();

    /**
     * 删除所有排班数据
     * @return
     */
    boolean deleteSchedule();
}

package com.pilifenghuolang.ISS.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pilifenghuolang.ISS.dao.*;
import com.pilifenghuolang.ISS.domain.PassFlow;
import com.pilifenghuolang.ISS.domain.Schedule;
import com.pilifenghuolang.ISS.domain.Store;
import com.pilifenghuolang.ISS.domain.Stuff;
import com.pilifenghuolang.ISS.schedule.Time;
import com.pilifenghuolang.ISS.service.ScheduleService;
import com.pilifenghuolang.ISS.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleDAO scheduleDAO;
    @Autowired
    PassFlowDao passFlowDao;
    @Autowired
    StoreDao storeDao;
    @Autowired
    StuffDao stuffDao;
    @Autowired
    private PreferenceDao timeDAO;

    @Override
    public boolean save(Schedule schedule) {
        return scheduleDAO.insert(schedule) > 0;
    }

    @Override
    public boolean update(Schedule schedule) {
        return scheduleDAO.updateById(schedule) > 0;
    }

    @Override
    public List<Schedule> getOneWeekByStuffId(Integer stuffId, Integer weekId) {
        LambdaQueryWrapper<Schedule> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Schedule::getStuffId,stuffId).eq(Schedule::getWeekId,weekId);
        return scheduleDAO.selectList(lqw);
    }

    @Override
    public List<Schedule> getOneDay(Date date) {
        LambdaQueryWrapper<Schedule> lqw = new LambdaQueryWrapper<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        lqw.like(Schedule::getDate,dateFormat.format(date));
        return scheduleDAO.selectList(lqw);
    }

    @Override
    public boolean initPassFlow() {
        LambdaQueryWrapper lqw = new LambdaQueryWrapper<>();
        boolean flag = passFlowDao.selectCount(lqw) == 0;
        if(flag){
            for (int weekId = 1;weekId <=5; weekId++){
                for(int dayOfTheWeek=1; dayOfTheWeek<=7; dayOfTheWeek++){
                    Integer weekValue=1;
                    if(dayOfTheWeek==6||dayOfTheWeek==7) weekValue=2;

                    PassFlow passFlow = new PassFlow();
                    passFlow.setWeekId(weekId);
                    passFlow.setDayOfWeek(dayOfTheWeek);
                    //date先留空
                    passFlow.setDate(null);
                    Random r = new Random();
                    double[] originList = {1.3,5.7,11.1,13.4,13.3,17.3,18.1,22.8,26.9,21.6,18.3,17.2,15.3,14.3,11.6,8.3,8.3,7.2,5.6,5.6,2.5,2.1,0.1,0.1};
                    for (int i = 0; i < originList.length; i++){
                        originList[i] += originList[i] * 0.2 * (r.nextDouble() - 0.5) * 2 ;
                        originList[i] *= weekValue;
                        passFlow.setPassFlow(i + 1,Math.round(originList[i] * 10) / 10.0);
                    }
                    passFlowDao.insert(passFlow);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean initSchedule() {
        LambdaQueryWrapper lqw = new LambdaQueryWrapper<>();
        boolean flag = scheduleDAO.selectCount(lqw) == 0;
        if(flag){
            for (int week = 1; week <=5; week++){
                // 创建商店实体类
                Store store = storeDao.selectById(1);
                // 读取员工，并为员工设置偏好
                LambdaQueryWrapper<Stuff> lqw1 = new LambdaQueryWrapper<>();
                lqw1.eq(Stuff::getStores,1);
                List<Stuff> stuffList = stuffDao.selectList(lqw1);
                for (Stuff stuff:stuffList) {
                    LambdaQueryWrapper<Time> lqw2 = new LambdaQueryWrapper<>();
                    lqw2.eq(Time::getStuffId,stuff.getId()).lt(Time::getType,2);
                    List<Time> timeList = timeDAO.selectList(lqw2);

                    ArrayList<Time> weekOfDayPreference = new ArrayList<>();
                    ArrayList<Time> periodPreference = new ArrayList<>();
                    for (Time time:timeList) {
                        switch(time.getType()){
                            case 0:
                                weekOfDayPreference.add(time);
                                break;
                            case 1 :
                                periodPreference.add(time);
                                break;
                        }
                    }
                    LinkedHashMap<Integer, ArrayList<Time>> preferenceMap = new LinkedHashMap<>();
                    preferenceMap.put(0,weekOfDayPreference);
                    preferenceMap.put(1,periodPreference);
                    stuff.setPreferenceMap(preferenceMap);
                }
                System.out.println(stuffList);
                // 为商店添加员工
                // 警钟长鸣！！！！
                // store.setStuffArr((ArrayList<Stuff>) stuffDAO.selectList(lqw1));

                store.setStuffArr((ArrayList<Stuff>) stuffList);
                //获取客流量数据
                LambdaQueryWrapper<PassFlow> lqw3 = new LambdaQueryWrapper<>();
                lqw3.eq(PassFlow::getWeekId,week);
                List<PassFlow> passFlowList = passFlowDao.selectList(lqw3);
                LinkedHashMap<String, ArrayList<Double>> passFlowNumWeekMap = new LinkedHashMap<>();
                for (PassFlow passflow:passFlowList) {
                    ArrayList<Double> list = new ArrayList<>();
                    for (int i = 0; i < 24; i++) {
                        list.add(i, passflow.getPassFlow(i + 1));
                    }
                    passFlowNumWeekMap.put(String.valueOf(passflow.getDayOfWeek()),list);
                }
                System.out.println(passFlowNumWeekMap);
                //
                LinkedHashMap<String, LinkedHashMap<Time, Stuff>> timeStuffWeekMap = store.intelligentScheduling(passFlowNumWeekMap);
                store.showStuffArrSchedule();
                for(String dayOfTheWeek : timeStuffWeekMap.keySet()){
                    System.out.print("周" + dayOfTheWeek + "：");
                    System.out.println(timeStuffWeekMap.get(dayOfTheWeek));
                }
                System.out.println(timeStuffWeekMap);
                //将排班数据保存到数据库
                for(String dayOfTheWeek : timeStuffWeekMap.keySet()){
                    LinkedHashMap<Time, Stuff> map = timeStuffWeekMap.get(dayOfTheWeek);
                    Date date = new Date();
                    long longTime = date.getTime();
                    longTime += (long) (((week - 1) * 7) + Integer.parseInt(dayOfTheWeek) - 1) * 24 * 60 * 60 * 1000;
                    date = new Date(longTime);
                    for (Time time : map.keySet()){
                        Schedule schedule = new Schedule();
                        schedule.setDayOfWeek(dayOfTheWeek);
                        schedule.setWeekId(week);
                        Stuff stuff = map.get(time);
                        schedule.setStuffId(stuff.getId());
                        schedule.setDate(date);
                        schedule.setStartTime(time.getStartTime());
                        schedule.setEndTime(time.getEndTime());
                        scheduleDAO.insert(schedule);
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePassFlow() {
        passFlowDao.deleteAll();
        return false;
    }

    @Override
    public boolean deleteSchedule() {
        scheduleDAO.deleteAll();
        return false;
    }
}

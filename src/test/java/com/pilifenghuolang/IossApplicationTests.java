package com.pilifenghuolang;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pilifenghuolang.ISS.dao.*;
import com.pilifenghuolang.ISS.domain.PassFlow;
import com.pilifenghuolang.ISS.domain.Schedule;
import com.pilifenghuolang.ISS.domain.Store;
import com.pilifenghuolang.ISS.domain.Stuff;
import com.pilifenghuolang.ISS.schedule.Time;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@SpringBootTest
class IossApplicationTests {

    @Autowired
    private StoreDao storeDAO;
    @Autowired
    private StuffDao stuffDAO;
    @Autowired
    private PassFlowDao passFlowDAO;
    @Autowired
    private PreferenceDao timeDAO;
    @Autowired
    private ScheduleDAO scheduleDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreateSchedule(){
        Store store = storeDAO.selectById(1);
        System.out.println(store);
    }

   /* @Test
    void testMain(){
        // 创建商店实体类
        Store store = storeDAO.selectById(1);
        // 读取员工，并为员工设置偏好
        LambdaQueryWrapper<Stuff> lqw1 = new LambdaQueryWrapper<>();
        lqw1.eq(Stuff::getStores,1);
        List<Stuff> stuffList = stuffDAO.selectList(lqw1);
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
        List<PassFlow> passFlowList = passFlowDAO.selectList(lqw3);
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
            longTime += (long) (Integer.parseInt(dayOfTheWeek) - 1) * 24 * 60 * 60 * 1000;
            date = new Date(longTime);
            for (Time time : map.keySet()){
                Schedule schedule = new Schedule();
                schedule.setDayOfWeek(dayOfTheWeek);
                schedule.setWeekId(1);
                Stuff stuff = map.get(time);
                schedule.setStuffId(stuff.getId());
                schedule.setDate(date);
                schedule.setStartTime(time.getStartTime());
                schedule.setEndTime(time.getEndTime());
                scheduleDAO.insert(schedule);
            }
        }

    }*/

}

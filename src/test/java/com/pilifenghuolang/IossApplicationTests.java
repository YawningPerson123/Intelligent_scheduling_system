package com.pilifenghuolang;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pilifenghuolang.ISS.dao.PassFlowDao;
import com.pilifenghuolang.ISS.dao.StoreDao;
import com.pilifenghuolang.ISS.dao.StuffDao;
import com.pilifenghuolang.ISS.dao.PreferenceDao;
import com.pilifenghuolang.ISS.domain.PassFlow;
import com.pilifenghuolang.ISS.domain.Store;
import com.pilifenghuolang.ISS.domain.Stuff;
import com.pilifenghuolang.ISS.schedule.Time;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
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

    @Test
    void contextLoads() {
    }

    @Test
    void testCreateSchedule(){
        Store store = storeDAO.selectById(1);
        System.out.println(store);
    }

    @Test
    void testMain(){
        // 创建商店实体类
        Store store = storeDAO.selectById(1);
        // 读取员工，并为员工设置偏好
        LambdaQueryWrapper<Stuff> lqw1 = new LambdaQueryWrapper<>();
        lqw1.eq(Stuff::getStores,1);
        List<Stuff> stuffList = stuffDAO.selectList(lqw1);
        for (Stuff stuff:stuffList) {
            LambdaQueryWrapper<Time> lqw2 = new LambdaQueryWrapper<>();
            lqw2.eq(Time::getStuff_id,stuff.getId()).lt(Time::getType,2);
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
        store.setStuffArr((ArrayList<Stuff>) stuffDAO.selectList(lqw1));
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
        //
        LinkedHashMap<String, LinkedHashMap<Time, Stuff>> timeStuffWeekMap = store.intelligentScheduling(passFlowNumWeekMap);
        store.showStuffArrSchedule();
        for(String dayOfTheWeek : timeStuffWeekMap.keySet()){
            System.out.print("周" + dayOfTheWeek + "：");
            System.out.println(timeStuffWeekMap.get(dayOfTheWeek));
        }

    }

}

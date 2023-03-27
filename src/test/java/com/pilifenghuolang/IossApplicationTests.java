package com.pilifenghuolang;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pilifenghuolang.ISS.dao.PassFlowDAO;
import com.pilifenghuolang.ISS.dao.StoreDAO;
import com.pilifenghuolang.ISS.dao.StuffDAO;
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
    private StoreDAO storeDAO;
    @Autowired
    private StuffDAO stuffDAO;
    @Autowired
    private PassFlowDAO passFlowDAO;

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
        // 为商店添加员工
        LambdaQueryWrapper<Stuff> lqw1 = new LambdaQueryWrapper<>();
        lqw1.eq(Stuff::getStores,1);
        store.setStuffArr((ArrayList<Stuff>) stuffDAO.selectList(lqw1));
        //获取客流量数据
        LambdaQueryWrapper<PassFlow> lqw2 = new LambdaQueryWrapper<>();
        List<PassFlow> passFlowList = passFlowDAO.selectList(lqw2);
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

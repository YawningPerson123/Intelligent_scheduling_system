package com.pilifenghuolang.Service;

import com.pilifenghuolang.ISS.service.ScheduleService;
import com.pilifenghuolang.ISS.service.impl.ScheduleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScheduleServiceTest {
    @Autowired
    ScheduleServiceImpl scheduleService;

    @Test
    void test1(){
        System.out.println(scheduleService);
        System.out.println(scheduleService.getOneWeekByStuffId(10001,1));
    }
}

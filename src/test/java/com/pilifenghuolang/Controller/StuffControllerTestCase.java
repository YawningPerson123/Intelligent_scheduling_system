package com.pilifenghuolang.Controller;

import com.pilifenghuolang.ISS.domain.Stuff;
import com.pilifenghuolang.ISS.service.StuffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StuffControllerTestCase {

    @Autowired
    private StuffService stuffService;

    @Test
    void test(){

        Stuff stuff=new Stuff(10018,"1","1","1","1","1",1,1);
        stuffService.save(stuff);

    }

}

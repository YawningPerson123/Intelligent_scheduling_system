package com.pilifenghuolang.Service;


import com.pilifenghuolang.ISS.domain.Stuff;
import com.pilifenghuolang.ISS.service.impl.StuffServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StuffServiceTestCase {

    @Autowired
    private StuffServiceImpl stuffService;

    @Test
    void testGetById(){
        System.out.println(stuffService.getById(1));
    }

    @Test
    void testSave(){
        Stuff stuff=new Stuff(25,"haha","1","1","1","1");
        System.out.println(stuffService.save(stuff));
    }
}

package com.pilifenghuolang.Dao;


import com.pilifenghuolang.ISS.dao.StuffDao;
import com.pilifenghuolang.ISS.domain.Stuff;
import com.pilifenghuolang.ISS.service.StuffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StuffDaoTestCase {

    @Autowired
    StuffDao stuffDao;

    @Test
    void testById(){
        System.out.println(stuffDao.selectById(1));
    }
}

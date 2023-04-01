package com.pilifenghuolang.ISS.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pilifenghuolang.ISS.dao.StuffDao;
import com.pilifenghuolang.ISS.domain.Stuff;
import com.pilifenghuolang.ISS.service.StuffService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuffServiceImpl implements StuffService {

    @Autowired
    StuffDao stuffDao;

    @Override
    public boolean save(Stuff stuff) {
        return stuffDao.insert(stuff)>0;
    }

    @Override
    public boolean update(Stuff stuff) {
        return stuffDao.updateById(stuff)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return stuffDao.deleteById(id)>0;
    }

    @Override
    public Stuff getById(Integer id) {
        return stuffDao.selectById(id);
    }

    //查询用,填入空串""即为查询全部
    @Override
    public IPage<Stuff> getByName(String name,int currentPage,int pageSize) {

        IPage page =new Page(currentPage,pageSize);
        LambdaQueryWrapper<Stuff> lqw=new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(name),Stuff::getName,name);


        return stuffDao.selectPage(page,lqw);
    }


}

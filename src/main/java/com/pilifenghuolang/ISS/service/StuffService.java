package com.pilifenghuolang.ISS.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pilifenghuolang.ISS.domain.Stuff;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StuffService {

    public boolean save(Stuff stuff);

    public boolean update(Stuff stuff);

    public boolean delete(Integer id);

    public Stuff getById(Integer id);

    //查询用
    public IPage<Stuff> getByName(String name, int currentPage,int pageSize);


}

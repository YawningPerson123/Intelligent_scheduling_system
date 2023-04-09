package com.pilifenghuolang.ISS.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pilifenghuolang.ISS.dao.PreferenceDao;
import com.pilifenghuolang.ISS.schedule.Time;
import com.pilifenghuolang.ISS.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceServiceImpl implements PreferenceService {

    @Autowired
    private PreferenceDao preferenceDao;

    @Override
    public boolean savePreference(Time time) {
        return preferenceDao.insert(time)>0;
    }


    @Override
    public boolean deletePreference(int id) {
        return preferenceDao.deleteById(id)>0;
    }


    //供controller的两条接口使用
    @Override
    public List<Time> getPreference(int stuffId) {
        LambdaQueryWrapper<Time> lqw=new LambdaQueryWrapper<>();
        lqw.eq(Time::getStuffId,stuffId);
        return preferenceDao.selectList(lqw);
    }
}

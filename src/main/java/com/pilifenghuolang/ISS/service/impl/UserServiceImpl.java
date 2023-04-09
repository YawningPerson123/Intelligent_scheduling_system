package com.pilifenghuolang.ISS.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pilifenghuolang.ISS.dao.UserDao;
import com.pilifenghuolang.ISS.domain.User;
import com.pilifenghuolang.ISS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(int userId, String password) {
        LambdaQueryWrapper<User> lqw=new LambdaQueryWrapper<>();
        lqw.eq(User::getUserId,userId).eq(User::getPassword,password);
        return userDao.selectOne(lqw);
    }
}

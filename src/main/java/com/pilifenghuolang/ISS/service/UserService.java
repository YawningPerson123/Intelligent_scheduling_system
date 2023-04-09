package com.pilifenghuolang.ISS.service;

import com.pilifenghuolang.ISS.domain.User;

public interface UserService {

    public User login(int userId,String password);
}

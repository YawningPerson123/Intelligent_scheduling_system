package com.pilifenghuolang.ISS.service.impl;

import com.pilifenghuolang.ISS.dao.TokenDao;
import com.pilifenghuolang.ISS.domain.User;
import com.pilifenghuolang.ISS.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenDao tokenDao;

    @Override
    public boolean updateToken(String userId, String token) {
        return tokenDao.updateToken(userId,token);
    }

    @Override
    public User tokenConfirmation(String token) {
        return tokenDao.tokenConfirmation(token);
    }
}

package com.pilifenghuolang.ISS.service;

import com.pilifenghuolang.ISS.domain.User;

public interface TokenService {

    public boolean updateToken(String userId, String token);

    public User tokenConfirmation(String token);
}

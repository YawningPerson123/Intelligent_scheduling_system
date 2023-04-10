package com.pilifenghuolang.ISS.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TokenDao {

    @Update("update user set token=#{token} WHERE user_id=#{userId};")
    boolean updateToken(int userId,String token);
}

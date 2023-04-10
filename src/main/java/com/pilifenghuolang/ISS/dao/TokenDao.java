package com.pilifenghuolang.ISS.dao;

import com.pilifenghuolang.ISS.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TokenDao {

    @Update("update user set token=#{token} WHERE user_id=#{userId};")
    boolean updateToken(String userId,String token);

    @Select("SELECT * FROM user WHERE token=#{token};")
    User tokenConfirmation(String token);

}

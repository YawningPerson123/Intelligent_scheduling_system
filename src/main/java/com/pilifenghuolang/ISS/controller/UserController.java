package com.pilifenghuolang.ISS.controller;

import com.pilifenghuolang.ISS.Util.Token;
import com.pilifenghuolang.ISS.dao.TokenDao;
import com.pilifenghuolang.ISS.domain.User;
import com.pilifenghuolang.ISS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenDao tokenDao;

    @GetMapping("/login")
    public Result login(@RequestBody User user){
        User loginUser=userService.login(user.getUserId(),user.getPassword());
        if(loginUser!=null){
            Token token=new Token(UUID.randomUUID()+"");
            tokenDao.updateToken(user.getUserId(),token+"");
            return new Result(Code.GET_OK,token,"登陆成功");
        }else{
            return new Result(Code.GET_ERR,null,"登陆失败");
        }
    }
}

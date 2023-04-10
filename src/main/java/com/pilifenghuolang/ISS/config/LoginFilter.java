package com.pilifenghuolang.ISS.config;

import com.pilifenghuolang.ISS.domain.User;
import com.pilifenghuolang.ISS.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = {"/schedule/*","/stuffs/*"},filterName = "LoginFilter ")
@Configuration
@Order(2)
public class LoginFilter implements Filter {

    @Autowired
    private TokenService tokenService;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;


        String path=((HttpServletRequest) req).getServletPath();
        if(path.equals("/login")){
            chain.doFilter(request,response);
        }else{
            String token =request.getHeader("token");
            User user=tokenService.tokenConfirmation(token);
            if(user!=null){
                chain.doFilter(request,response);
            }
        }


    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

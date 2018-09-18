package com.example.demo.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.config.MyCustomException;
import com.example.demo.constant.Constants;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.util.MD5Util;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author byron
 * @date 2018/8/24 11:18
 */

@RestController
@RequestMapping(value = "/user")
@Validated
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping(value = "/login",name = "登陆")
  public Object login(@NotNull String userName,
      @NotNull String password,String remember,
      HttpServletRequest req,HttpServletResponse resp){
    EntityWrapper<User> wrapper = new EntityWrapper<>();
    User user = userService.selectOne(wrapper.eq("user_name",userName).eq("password",password));
    if(user==null)
      throw new MyCustomException("用户不存在");
    //将用户信息保存至session
    req.getSession().setAttribute(Constants.WITH_SESSION_USER, user);
    if("1".equals(remember)){
      long validTime = System.currentTimeMillis() + (Constants.COOKIE_MAX_AGE * 1000);
      String cookieValue = MD5Util
          .encrypt(user.getId() + ":" + password + ":" + validTime + ":" + Constants.LOGIN_KEY);
      cookieValue = user.getId()+":"+cookieValue;
      Cookie cookie = new Cookie(Constants.LOGIN_COOKIE_SIGN,cookieValue);
      //设置cookie的过期时间为5天
      cookie.setMaxAge(60*60*24*5);
      cookie.setPath("/");
      resp.addCookie(cookie);
      //自动登陆session存活时间为cookie过期时间
      req.getSession().setMaxInactiveInterval(cookie.getMaxAge()); // Session保存两小时
    }else{
      //如果用户没有自动登陆则session的存活时间为2小时
      req.getSession().setMaxInactiveInterval(60*60*2); // Session保存两小时
    }

    Map<String,Object> result = new HashMap<>();
    result.put("status",1);
    result.put("message","登陆成功");
    return result;
  }

}

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
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author byron
 * @date 2018/8/24 11:18
 */

@RestController  //注意：如果使用了thymeleaf模板引擎来跳转页面，则不能使用RestController来跳转。
@RequestMapping(value = "/user")
@Validated
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping(value = "/index")
  public Object abc(){
//    Cookie[] cookies = req.getCookies();
//    HttpSession session = req.getSession();
//    Object o = session.getAttribute(Constants.WITH_SESSION_USER);
//    ModelAndView modelAndView = new ModelAndView();
//    if(o != null){
//      User user = (User)o;
//      modelAndView.addObject("user",user);
//      modelAndView.setViewName("home");
//      return modelAndView;
//    }else if(cookies != null){
//      String cookieValue = null;
//      for(Cookie cookie : cookies){
//        if(Constants.LOGIN_COOKIE_SIGN.equals(cookie.getName())){
//          cookieValue = cookie.getValue();
//          break;
//        }else if(Constants.JSESSIONID.equals(cookie.getName())){
//          modelAndView.setViewName("login");
//          return modelAndView;
//        }
//      }
//      cookieValue = cookieValue.split(":")[0];
//      User user = userService.selectById(Long.valueOf(cookieValue));
//      modelAndView.addObject("user",user);
//      modelAndView.setViewName("home");
//      return modelAndView;
//    }else{
//      modelAndView.setViewName("login");
//      return modelAndView;
//    }
    return new ModelAndView("login");
  }

  @PostMapping(value = "/login",name = "登陆")
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
      req.getSession().setMaxInactiveInterval(cookie.getMaxAge());
    }
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("user",user);
    modelAndView.setViewName("home");
    return modelAndView;
  }

  @GetMapping(value = "/loginout")
  public Object loginout(HttpServletRequest req,HttpServletResponse resp){
    //清空session
    req.getSession().invalidate();
    for(Cookie cookie: req.getCookies()){
      //清空cookie
      cookie.setMaxAge(0);
    }
    return "login";
  }
  
  @GetMapping(value = "/loginError")
  public Object loginError(){
    return new ModelAndView("login_error");
  }

}

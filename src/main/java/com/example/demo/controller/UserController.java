package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author byron
 * @date 2018/8/24 11:18
 */

@RestController  //注意：如果使用了thymeleaf模板引擎来跳转页面，则不能使用RestController来跳转。
@Validated
public class UserController {

  @Autowired
  private UserService userService;
  
  @Autowired
  private PasswordEncoder passwordEncoder;

  @GetMapping(value = "/loginPage",name = "登陆页面")
  public Object abc(){
    return new ModelAndView("login");
  }
  
  @RequestMapping("/index")
  public Object root() {
    return new ModelAndView("home");
  }
  
  @GetMapping(value = "/registerPage",name = "注册页面")
  public Object registerPage(){
    return new ModelAndView("registerPage");
  }
  
  @PostMapping(value = "/register",name = "注册")
  public Object register(@NotNull String username,@NotNull String password){
    User user = new User();
    user.setUsername(username);
    user.setPassword(passwordEncoder.encode(password));
    user.setNickName(username);
    userService.insert(user);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("user",user);
    modelAndView.setViewName("home");
    return modelAndView;
  }
  
  @GetMapping(value = "/loginErrorPage")
  public Object loginError(){
    return new ModelAndView("login_error");
  }
  
}

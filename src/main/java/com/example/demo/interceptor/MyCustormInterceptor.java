package com.example.demo.interceptor;

import com.example.demo.config.MyCustomException;
import com.example.demo.constant.Constants;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author byron
 * @date 2018/8/20 11:22
 */

@Aspect
@Component
public class MyCustormInterceptor {


  @Autowired
  protected UserService userService;

  public static final String TOKEN = "token";
  @Pointcut("execution(* com.example.demo.controller.*.*(..)) && !execution(public * com.example.demo.controller.UserController.*(..))")
  public void pointcut(){}

  @Before("pointcut()")
  public void before(){
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest req = attributes.getRequest();
    HttpSession session = req.getSession();
    Cookie[] cookies = req.getCookies();
    //登陆时校验cookie
    String cookieValue = null;
    if(cookies == null)
      throw new MyCustomException("请先登陆");
    for(Cookie cookie : cookies){
      if(Constants.LOGIN_COOKIE_SIGN.equals(cookie.getName())){
        cookieValue = cookie.getValue();

        break;
      }
    }
    User user = (User)session.getAttribute(Constants.WITH_SESSION_USER);
    if(cookieValue == null && user == null)
      throw new MyCustomException("请先登陆");
    else if(cookieValue != null ){
      cookieValue = cookieValue.split(":")[0];
      user = userService.selectById(Long.valueOf(cookieValue));
      session.setAttribute(Constants.WITH_SESSION_USER,user);
    }
  }

  @AfterReturning(returning = "object",pointcut = "pointcut()")
  public void afterReturning(Object object){
    System.out.println("这是aop的afterReturning方法返回的数据为"+object);
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest req = attributes.getRequest();

    Object token = req.getSession().getAttribute(TOKEN);
    if(token != null){
//      req.getSession().removeAttribute(TOKEN);
    }
  }
  @After("pointcut()")
  public void  after(){
    System.out.println("这是aop的after方法");
  }
}

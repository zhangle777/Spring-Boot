//package com.example.demo.interceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// * 自定义拦截器
// */
//public class CustomInterceptor implements HandlerInterceptor {
//
//  @Override
//  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//      throws Exception {
//    System.out.println("拦截器1preHandle方法执行");
//    return true;
//  }
//
//  @Override
//  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//      ModelAndView modelAndView) throws Exception {
//    System.out.println("拦截器1postHandle方法执行");
//  }
//
//  @Override
//  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
//      Object handler, Exception ex) throws Exception {
//    System.out.println("拦截器1afterCompletion方法执行");
//  }
//}

//package com.example.demo.interceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///** 自定义mvc相关配置
// * @author byron
// * @date 2018/11/22 14:11
// */
//@Configuration
//@ConditionalOnWebApplication
//public class CustomWebMvcConfigurer implements WebMvcConfigurer {
//
//  /**
//   * 自定义拦截器并拦截指定请求路径
//   * @param registry
//   */
//  @Override
//  public void addInterceptors(InterceptorRegistry registry) {
//    registry.addInterceptor(new CustomInterceptor());
//    registry.addInterceptor(new CustomInterceptor2());
//  }
//}

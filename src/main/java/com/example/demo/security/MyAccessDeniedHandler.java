//package com.example.demo.security;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
///**
// * @author byron
// * @date 2018/12/19 16:54
// */
//@Component
//public class MyAccessDeniedHandler implements AccessDeniedHandler {
//
//  @Override
//  public void handle(HttpServletRequest request, HttpServletResponse response,
//      AccessDeniedException accessDeniedException) throws IOException, ServletException {
//    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//    response.setCharacterEncoding("UTF-8");
//    PrintWriter out = response.getWriter();
//    out.write("{\"status\":\"error\",\"msg\":\"权限不足，请联系管理员!\"}");
//    out.flush();
//    out.close();
//  }
//}

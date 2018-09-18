package com.example.demo.config;

import com.example.demo.pojo.resp.MyExceptionResp;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常控制
 */
@RestControllerAdvice
public class GlobalDefultExceptionHandler{

  @ExceptionHandler(Exception.class)
  public Object exceptionHandler(Exception e){
      if(e instanceof MyCustomException || e instanceof IllegalArgumentException)
        return new MyExceptionResp(9,e.getMessage());
      e.printStackTrace();
      return new MyExceptionResp(-1,"系统异常");
  }
}

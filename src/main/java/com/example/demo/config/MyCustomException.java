package com.example.demo.config;

/**
 * 自定义异常类
 */
public class MyCustomException extends RuntimeException {

  public MyCustomException(String message){
    super(message);
  }

}

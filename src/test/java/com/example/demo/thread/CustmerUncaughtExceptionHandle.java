package com.example.demo.thread;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 自定义线程运行时异常处理器
 */
public class CustmerUncaughtExceptionHandle implements UncaughtExceptionHandler {
  
  @Override
  public void uncaughtException(Thread t, Throwable e) {
    System.out.println("线程："+t.getName()+"，抛出异常："+e.getMessage()+","+e.getStackTrace());
  }
}

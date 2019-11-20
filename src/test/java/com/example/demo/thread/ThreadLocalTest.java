package com.example.demo.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程本地变量测试
 */
public class ThreadLocalTest implements Runnable{
  //使用ThreadLocal来申请变量。这样这个变量就属于线程私有的、独立的。不受其他线程影响
//  private static ThreadLocal<SimpleDateFormat> simpleDateFormat =
//      ThreadLocal.withInitial(()-> new SimpleDateFormat("yyyy-MM-dd"));
  
  private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
  @Override
  public synchronized void run() {
    try {
//      Date date = simpleDateFormat.get().parse("2019-11-19");
      Date date  = simpleDateFormat.parse("2019-11-19");
      System.out.println(Thread.currentThread().getName()+"============"+date);
    }catch (ParseException exception) {
  
    }
  }
  
  public static void main(String[] args) {
    ThreadLocalTest t = new ThreadLocalTest();
    Thread thread = new Thread(t);
    Thread thread2 = new Thread(t);
    thread.start();
    thread2.start();
  }
}

package com.example.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class CallableTest implements Callable<String> {
  
  private AtomicInteger flag = new AtomicInteger(0);
  
  public AtomicInteger getFlag() {
    return flag;
  }
  
  public void setFlag(AtomicInteger flag) {
    this.flag = flag;
  }
  
  @Override
  public String call() throws Exception {
    if (flag.get() == 0) {
      return "flag = 0";
    } else if (flag.get() == 1) {
      try {
        while (true) {
          System.out.println("hahahahaa");
          Thread.sleep(2000);
        }
      } catch (InterruptedException e) {
        e.getStackTrace();
      }
      return "false";
    } else {
      throw new Exception("Bad flag value!");
    }
  }
  
  public static void main(String[] args) {
    //创建执行服务
    ExecutorService service = Executors.newFixedThreadPool(5);
    //创建三个任务
    CallableTest c1 = new CallableTest();
    c1.setFlag(new AtomicInteger(0));
    CallableTest c2 = new CallableTest();
    c2.setFlag(new AtomicInteger(1));
    CallableTest c3 = new CallableTest();
    c3.setFlag(new AtomicInteger(2));
    try {
      Future<String> f1 = service.submit(c1);
      System.out.println("f1任务的返回值："+f1.get());
      Future<String> f2 = service.submit(c1);
      Thread.sleep(5000);
      f2.cancel(true);
      System.out.println("f2任务停止");
      Future<String> f3 = service.submit(c1);
      System.out.println("f3任务的返回值："+f3.get());
    }catch (Exception e){
      e.printStackTrace();
    }
    service.shutdown();
  }
}

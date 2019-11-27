package com.example.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定时执行线程池demo
 */
public class ScheduledExecutorDemo {
  
  public static void main(String[] args) throws Exception{
    ScheduledExecutorService ste = Executors.newScheduledThreadPool(5);
    TaskDemo2 taskDemo2 = new TaskDemo2();
    for (int i = 0;i<3;i++){
      ste.scheduleAtFixedRate(taskDemo2,5,2,TimeUnit.SECONDS);
    }
    System.out.println("任务在后台开始了");
  }
}

class TaskDemo implements Callable<String>{
  
  @Override
  public String call() throws Exception {
    System.out.println(Thread.currentThread().getName()+"正在执行准备休息2秒");
    Thread.sleep(2000);
    return "执行结束";
  }
}
class TaskDemo2 implements Runnable{
  
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName()+"正在执行准备休息2秒");
  }
}

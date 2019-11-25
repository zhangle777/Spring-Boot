package com.example.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class CallableTest implements Callable<Integer> {
  
  private AtomicInteger flag = new AtomicInteger(0);
  
  public AtomicInteger getFlag() {
    return flag;
  }
  
  public void setFlag(AtomicInteger flag) {
    this.flag = flag;
  }
  
  @Override
  public Integer call() throws Exception {
    for(int i = 0 ;i<= 20;i++){
      flag.incrementAndGet();
      System.out.println("i的值"+i);
      Thread.sleep(200);
    }
    return flag.get();
  }
  
  public static void main(String[] args) {
    //创建执行服务
    ExecutorService service = Executors.newFixedThreadPool(5);
    CallableTest c = new CallableTest();
    try {
      Future<Integer> future = service.submit(c);
      while (!future.isDone()){
        System.out.println("任务未结束");
        Thread.sleep(1000);
        if(future.cancel(true)){
          System.out.println("任务被取消了");
         break;
        }
      }
//      System.out.println("任务已结束flag的值"+future.get());
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      service.shutdown();
    }
  }
}

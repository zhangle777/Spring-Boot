package com.example.demo.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池demo
 */
public class ExecutorDemo {
  
  public static void main(String[] args) throws Exception {
    //创建一个固定大小的线程池
    ExecutorService es = Executors.newFixedThreadPool(5);
    //创建一个有任务提交时就立即创建新线程的线程池，默认空闲线程会被保留60秒。
//    ExecutorService es2 = Executors.newCachedThreadPool();
    //通过ThreadPoolExecutor创建线程池
    //即创建一个核心线程数为5，最大线程数为10，空闲线程超过30秒就被回收，任务队列容量为5的线程池。
    ThreadPoolExecutor threadPoolExecutor =
        new ThreadPoolExecutor(5,10,
            30, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(5),new RejectedExecution());
    //创建任务集合
    Task task = new Task();
    List<Task> tasks = new ArrayList<>();
    tasks.add(task);
    tasks.add(task);
    tasks.add(task);
    tasks.add(task);
    //使用CompletionService提交多个任务。
//    CompletionService<Integer> ecs = new ExecutorCompletionService<>(threadPoolExecutor);
    //执行给定的任务集，返回其中一个任务的结果
//    Integer result = threadPoolExecutor.invokeAny(tasks);
    //执行给定任务集,返回所有任务的结果。
    List<Future<Integer>> result = threadPoolExecutor.invokeAll(tasks);
    for (Future item: result) {
      System.out.println("执行结果"+item.get());
    }
   
//    for(int i = 0; i<10;i++){
//      ecs.submit(task);
//    }
//    Thread.sleep(300);
////    for (int i = 0;i<20;i++){
////      Future<Integer> r = ecs.take();
////      System.out.println("执行结果："+r.get());
////    }
//    Future<Integer> r = ecs.poll();
//    while(r != null){
//      System.out.println("执行结果："+r.get());
//      r = ecs.poll();
//    }
    threadPoolExecutor.shutdown();
  }
}

/**
 * 任务
 */
class Task implements Callable<Integer>{
  //使用ThreadLocal来表示该变量属于线程独立
//  ThreadLocal<AtomicInteger> j = ThreadLocal.withInitial(()->new AtomicInteger(0));
    volatile AtomicInteger j = new AtomicInteger(0);
//  int j = 0;
  @Override
  public Integer call() throws Exception {
      for(int i = 0;i<100;i++){
//        j.incrementAndGet();
      System.out.println("当前线程"+Thread.currentThread()+"结果:"+j.incrementAndGet());
//      Thread.sleep(500);
      }
//      return Thread.currentThread().getName()+","+j.get();
      return j.get();
  }
}

/**
 * 任务拒绝策略
 */
class RejectedExecution implements RejectedExecutionHandler{
  
  @Override
  public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
    System.out.println(r.toString()+"拒绝了提交");
  }
}

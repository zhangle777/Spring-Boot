package com.example.demo.thread;

public class ThreadTest implements Runnable{
    Integer age = 1;
  
  @Override
  public void run() {
    
      while (age<200){
        synchronized (this){
        System.out.println("当前线程："+Thread.currentThread().getName()+"当前值："+age);
        age++;
        try {
//          Thread.sleep(30);
          wait(30);
        }catch (Exception e){
          e.printStackTrace();
        }
        }
      }
  }
  
  public static void main(String[] args) {
    ThreadTest thread = new ThreadTest();
    Thread thread1 = new Thread(thread,"线程1");
    Thread thread2 = new Thread(thread,"线程2");
    thread1.start();
    thread2.start();
    System.out.println("hahaha");
  }
}

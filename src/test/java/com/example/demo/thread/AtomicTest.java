package com.example.demo.thread;

/**
 * 测试volatile关键字不能保证原子性
 */
public class AtomicTest implements Runnable{
  //而使用AtomicInteger原子类可以保证num变量的原子性。AtomicInteger相关的原子类采用CAS（无锁操作）
//  AtomicInteger num = new AtomicInteger();
  //比Atomic性能更高效的原子类。采用分段锁技术。保证数据的一致性。
//  LongAdder num = new LongAdder();
  
  volatile int num = 0;
  @Override
  public void run() {
   for(int j = 0;j<1000;j++){
     //使用volatile关键字不能保证num变量操作的原子性。
     num++;
   }
  }
  
  private long total() {
    return num;
  }
  
  public static void main(String[] args) {
    AtomicTest thred = new AtomicTest();
    for (int i = 0;i<20;i++){
      Thread thread = new Thread(thred);
      thread.start();
    }
  
    //判断大于两个活跃线程，是因为，一个Java程序，还有主线程和gc线程
    while (Thread.activeCount()>2){
      Thread.yield();
    }
    System.out.println(thred.total());
    
  }
}

package com.example.demo.thread;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 阻塞队列测试
 */
public class BlockingQueueTest implements Cloneable{
  private String name;
  
  public BlockingQueueTest(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public static void main(String[] args)throws Exception{
    BlockingQueueTest blockingQueueTest  = new BlockingQueueTest("漳卅");
    BlockingQueueTest blockingQueueTest1 = (BlockingQueueTest)blockingQueueTest.clone();
    System.out.println(blockingQueueTest.getName());
    System.out.println(blockingQueueTest1.getName());
  }
}

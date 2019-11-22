package com.example.demo.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 读/写锁
 */
public class ReadWriteLockTest {
  
  private List names = new ArrayList();
  public synchronized void add(String name){
    names.add(name);
  }
  
  public synchronized void printAll(){
    for(int i = 0;i<names.size();i++){
      System.out.print(names.get(i)+",");
    }
  }
  public static void main(String[] args) {
    final ReadWriteLockTest s1 = new ReadWriteLockTest();
    for(int i = 0; i<2;i++){
      new Thread(){
        @Override
        public void run() {
          s1.add("A");
          s1.add("B");
          s1.add("C");
          s1.printAll();
        }
      }.start();
    }
  }
}

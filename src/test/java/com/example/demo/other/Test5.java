package com.example.demo.other;

import com.example.demo.annotation.Test;

/**
 * @author byron
 * @date 2018/12/25 11:34
 */
@Test("haha")
public class Test5 {

  public static void main(String[] args) {
//    Test test = Test5.class.getAnnotation(Test.class);
//    System.out.println(test.value());

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(5*1000);
        }catch (InterruptedException e){
          e.printStackTrace();
        }
        System.out.println("hahaha");
      }
    }).start();
    System.out.println("fsgsadg");
  }
}

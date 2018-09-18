/**
 * Copyright (C), 2015-2018, XXX有限公司 FileName: SubTest Author:   byron Date:     2018/8/6 14:02
 * Description: History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.other;

public class SubTest implements Runnable {

  public static Integer integer;

  @Override
  public void run() {
    integer = 3;
    System.out.println("当前线程"+Thread.currentThread().getName()+",变量为"+integer);
    integer = 6;
    System.out.println("当前线程"+Thread.currentThread().getName()+",变量为"+integer*2);
  }

  public static void main(String[] args) {
    SubTest test = new SubTest();
    for(int i =1;i<=50;i++){
      Thread thread = new Thread();
      thread.start();
    }
  }
}


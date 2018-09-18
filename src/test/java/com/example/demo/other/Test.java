/**
 * Copyright (C), 2015-2018, XXX有限公司 FileName: TestDao Author:   byron Date:     2018/8/6 14:00
 * Description: History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.other;

/**
 * 实现双重检验锁
 */
class Singleton {


  private volatile static Singleton instance;

  private Singleton(){}

  public static Singleton getInstance(){
    //第一次在没有同步之前判断一次。如果为空则进入同步代码块中
    if(instance == null){
      synchronized (Test.class){
        //在同步代码块中需再次进行判断，以保证线程安全。
        if(instance == null){
          instance = new Singleton();
        }
      }
    }
    return instance;
  }
}

/**
 * 实现延迟加载(懒汉式单例)
 */
class LazySingleton {
  private static LazySingleton lazySingleton;
  private LazySingleton(){}
  public synchronized LazySingleton getInstance(){
    if(lazySingleton == null){
      lazySingleton = new LazySingleton();
    }
    return lazySingleton;
  }
}
public class Test{
  private static LazySingleton lazySingleton;
  class TestSon {
    private LazySingleton lazySingleton;
  }

  public static void main(String[] args) throws Exception {
//    int i = 1_000_000_000;
//    Integer t = null;
//    Integer d = t * 10;
//    System.out.println(d);
//    byte p = 3;
//    int a = 3;
//    p = (byte) a;
//    System.out.println(Boolean.toString(10,16));

//    boolean i1= false;
//    boolean i2= true;
//    boolean i3= true;
//    if(i1 && (i2 && i3)){
//      System.out.println("ss");
//    }
  }
}

package com.example.demo.other;

/**
 * @author byron
 * @date 2018/11/16 10:23
 */
public interface InterfaceA extends InterfaceAA,InterfaceAAA{
  String sSs = "21321";
  default void test(){
  
  }
  
  
  
  static void test2(){
    System.out.println("hahaha");
  }

}

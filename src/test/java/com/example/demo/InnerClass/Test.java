package com.example.demo.InnerClass;


/**
 * @author byron
 * @date 2019/1/29 13:11
 */
public class Test {

  public static void main(String[] args) {
    InnerClassTest innerClassTest = new InnerClassTest("我是谁");
    Object inner = innerClassTest.getInner();

  }

}

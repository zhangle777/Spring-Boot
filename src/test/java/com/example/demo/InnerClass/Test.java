package com.example.demo.InnerClass;


import com.example.demo.InnerClass.InnerClassTest.Inner;

/**
 * @author byron
 * @date 2019/1/29 13:11
 */
public class Test {

  public static void main(String[] args) {
    InnerClassTest innerClassTest = new InnerClassTest();
    Inner inner = innerClassTest.new Inner();

  }

}

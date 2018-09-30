package com.example.demo.other.JDKDynamicProxy;

/**
 * 真实对象
 * JDK只能代理实现了接口的类
 * 没有实现接口的类不能实现JDK动态代理。
 * @author byron
 * @date 2018/9/30 9:33
 */
public class Byron implements ByronIntereface {


  public void hello() {
    System.out.println("哈哈111");
  }


  public void test() {
    System.out.println("dadahsddsa");
  }
}

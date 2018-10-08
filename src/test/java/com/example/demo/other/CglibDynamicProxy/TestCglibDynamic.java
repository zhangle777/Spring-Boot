package com.example.demo.other.CglibDynamicProxy;

/**
 * @author byron
 * @date 2018/10/8 16:12
 */
public class TestCglibDynamic {

  public static void main(String[] args) {
    Byron byron = new Byron();
    CglibDynamicProxy proxy = new CglibDynamicProxy();
    byron = (Byron)proxy.getObject(byron);
    byron.say();

  }
}

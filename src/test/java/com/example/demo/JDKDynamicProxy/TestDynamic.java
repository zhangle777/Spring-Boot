package com.example.demo.JDKDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author byron
 * @date 2018/9/30 9:46
 */
public class TestDynamic {

  public static void main(String[] args) {
    Byron byron = new Byron();
   InvocationHandler byronIntereface = new JDKDynamicProxy(byron);//调用处理器

    ByronIntereface real = (ByronIntereface) Proxy.newProxyInstance(byronIntereface.getClass().
        getClassLoader(),byron.getClass().getInterfaces(),byronIntereface); //
    real.hello();
  }
}

package com.example.demo.JDKDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * @author byron
 * @date 2018/9/30 10:03
 */
public class JDKDynamicProxy implements InvocationHandler {
  private Object object;

  public JDKDynamicProxy(Object o) {
    this.object = o;
  }

  @Override
  public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
    System.out.println(o.getClass().getName()+"执行之前");
//    System.out.println(method.getName());
    method.invoke(object,objects);
    System.out.println(o.getClass().getName()+"执行之后");
    return null;
  }
}

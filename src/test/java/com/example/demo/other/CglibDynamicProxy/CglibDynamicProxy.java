package com.example.demo.other.CglibDynamicProxy;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author byron
 * @date 2018/9/30 11:24
 */
public class CglibDynamicProxy implements MethodInterceptor {

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    return null;
  }
}

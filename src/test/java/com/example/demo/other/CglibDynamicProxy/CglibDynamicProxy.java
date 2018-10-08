package com.example.demo.other.CglibDynamicProxy;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author byron
 * @date 2018/9/30 11:24
 */
public class CglibDynamicProxy implements MethodInterceptor {

  public Object getObject(Object object) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(object.getClass());
    enhancer.setCallback(this);
    return enhancer.create();
  }

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    System.out.println("调用之前");
    System.out.println("调用方法为："+method.getName());
    System.out.println("调用代理方法为："+methodProxy);
    System.out.println("调用代理方法为："+methodProxy.getSuperName());
    methodProxy.invokeSuper(o,objects);
    System.out.println("调用之后");
    return null;
  }
}

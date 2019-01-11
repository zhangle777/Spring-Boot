package com.example.demo.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 用于手动获取bean的util
 * @author byron
 * @date 2019/1/11 16:17
 */
@Component
public class SpringUtil implements ApplicationContextAware {

  private static ApplicationContext applicationContext;
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    if(SpringUtil.applicationContext == null) {
      SpringUtil.applicationContext = applicationContext;
      System.out.println("====spring容器初始化成功===");
    }
  }

  //获取applicationContext
  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  //通过name获取 Bean.
  public static Object getBean(String name){
    return getApplicationContext().getBean(name);
  }

  //通过class获取Bean.
  public static <T> T getBean(Class<T> clazz){
    return getApplicationContext().getBean(clazz);
  }

  //通过name,以及Clazz返回指定的Bean
  public static <T> T getBean(String name,Class<T> clazz){
    return getApplicationContext().getBean(name, clazz);
  }
}

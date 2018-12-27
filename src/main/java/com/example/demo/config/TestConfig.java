package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 测试EnableConfiguration所需要的类
 * @author byron
 * @date 2018/12/25 16:25
 */
@Component
@PropertySource(value = "classpath:config/config.properties",encoding = "utf-8")
@ConfigurationProperties(prefix = "testconfig")
public class TestConfig {

  private String name;
  private Integer age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}

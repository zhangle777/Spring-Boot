/**
 * Copyright (C), 2015-2018, XXX有限公司 FileName: Student Author:   byron Date:     2018/8/8 9:41
 * Description: History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.pojo;


import com.example.demo.annotation.DoubleSerialize;
import com.example.demo.annotation.JsonUrlPrefix;
import com.example.demo.annotation.UrlPrefixSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Student{
  private Integer id;
  private String name;
  private Integer age;
  private Double salary;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

//  @JsonSerialize(using = UrlPrefixSerialize.class)
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

  @JsonSerialize(using = DoubleSerialize.class)
  public Double getSalary() {
    return salary;
  }
  public void setSalary(Double salary) {
    this.salary = salary;
  }
}

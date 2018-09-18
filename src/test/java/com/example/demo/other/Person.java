/**
 * Copyright (C), 2015-2018, XXX有限公司 FileName: Person Author:   byron Date:     2018/8/6 14:02
 * Description: History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.other;

public class Person {
  public String str = "22";
  private String name;
  private Integer age;

  public Object getSon(){
    Son son = new Son();
    son.setAge(12);
    return son;
  }
  public String getName() {
    return name;
  }

  public String getStr() {
    return str;
  }

  public void setStr(String str) {
    this.str = str;
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

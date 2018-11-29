package com.example.demo.other;

import java.math.BigDecimal;
import org.springframework.beans.BeanUtils;

/**
 * @author byron
 * @date 2018/8/27 17:13
 */
public class Test2 {

  private String string;
  String dd;

  public static void main(String[] args) {

    Person person = new Person();
    Person person1 = new Son();
    Grandson<String,Object> grandson = new Grandson();
    System.out.println();
    if(person1 instanceof Person){
      System.out.println("12");
    }
    Object o = person.getSon();
    person.setAge(1);
    if(o instanceof Son){
      Son son = (Son) o;
      System.out.println(son.getAge());
    }

  }


}

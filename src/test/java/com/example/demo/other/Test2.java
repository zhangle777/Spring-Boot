package com.example.demo.other;

/**
 * @author byron
 * @date 2018/8/27 17:13
 */
public class Test2 {

  public static void main(String[] args) {

    Person person = new Person();
    Object o = person.getSon();
    person.setAge(1);
    if(o instanceof Son){
      Son son = (Son) person;
      System.out.println(son.getAge());
    }

  }


}

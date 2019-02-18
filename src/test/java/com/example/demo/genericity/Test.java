package com.example.demo.genericity;

/**
 * @author byron
 * @date 2019/2/18 9:29
 */
public class Test {

  public static void main(String[] args) {
    Integer[] array = {12,32,22,33,21};
    Person<Integer> person = Person.test(array);
    System.out.println(person.getMin());
    System.out.println(person.getMax());

  }
}

package com.example.demo.other;

import java.util.ArrayList;
import java.util.List;

public class Collection {
  
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    list.add("张三");
    list.add("李四");
    list.add("王五");
    list.add(null);
    
    ArrayList<String> test = new ArrayList<>();
    test.add("杀杀杀");
    
    list2.add("AAA");
    list2.add("BBB");
    String [] a = new String[1];
    System.out.println(a);
    String [] list2Str = list2.toArray(a);
    System.out.println(list2Str);
    String [] objects = list.toArray(a);
    System.out.println(objects);
    for (Object o: objects){
      System.out.println(o);
    }
  }
}

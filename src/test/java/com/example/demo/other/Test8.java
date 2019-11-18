package com.example.demo.other;


import java.util.ArrayList;
import java.util.List;

public class Test8 {
  
  static boolean foo(char c){
    System.out.println(c);
    return true;
  }
  
  public static void main(String[] args) {
    int i = 0;
    for(foo('A');foo('B')&& (i<2);foo('c')){
      i++;
      foo('d');
    }
    int c = 2;
    for(;c<2;++c){
      System.out.println("hahaah");
    }
    System.out.println(c);
    List<Integer> stringList = new ArrayList<>();
    stringList.add(1);
    stringList.add(2);
    stringList.remove(1);
    System.out.println(121);
    StringBuffer stringBuffer = new StringBuffer("asss");
    StringBuilder sb = new StringBuilder("asss");
    stringBuffer.toString();
    int capacity = stringBuffer.capacity(); // value.length
    int length = stringBuffer.length(); //count
    stringBuffer.append("asss");
    System.out.println(capacity);
    System.out.println(length);
  }
}

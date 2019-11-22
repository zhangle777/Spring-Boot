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
    stringList.forEach(System.out::println);
    System.out.println("==================");
    StringBuffer stringBuffer = new StringBuffer("asss");
    stringBuffer.toString();
    int capacity = stringBuffer.capacity(); // value.length
    int length = stringBuffer.length(); //count
    System.out.println("添加之前的capacity"+capacity);
    System.out.println("添加之前的length"+length);
    stringBuffer.append("asss士大夫萨芬的说法是 速度法收到是是是飒飒是事实是是");
    capacity = stringBuffer.capacity();
    length = stringBuffer.length();
    System.out.println("添加之后的capacity"+capacity);
    System.out.println("添加之后的length"+length);
  }
}

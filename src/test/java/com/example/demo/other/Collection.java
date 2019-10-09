package com.example.demo.other;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Collection {
  
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    list.add("张三");
    list.add("李四");
    list.add("王五");
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.length();
    stringBuffer.capacity();
    list.add(null);
    String as = list.stream().collect(Collectors.joining(","));
    System.out.println(as);
    
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
    
    int x = 0,y=0,k=0;
    for(int z = 0;z<5;z++){
      if((++x>2)&&(++y>2)&&(k++>2)){
        x++;
        ++y;
        k++;
      }
    }
    System.out.println(x+""+y+""+k);
  }
}

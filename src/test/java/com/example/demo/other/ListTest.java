package com.example.demo.other;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Supplier;

public class ListTest {
  
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    //遍历集合的三种方式删除元素
  
    //一：普通循环
    for (int i = 0;i<list.size();i++){
      if("c".equals(list.get(i))){
       list.remove(i);
      }
    }
    //打印
    list.forEach(System.out::println);
    
    //二：增强循环 在这种遍历中不能调用remove方法
    for (String str : list){
      if("c".equals(str)){
        list.remove(str);//如果使用list.remove则会报错。
      }
    }
    //打印
    list.forEach(System.out::println);
    
    //三：迭代器遍历
    Iterator iterator = list.iterator();
    while (iterator.hasNext()){
      if("c".equals(iterator.next())){
        iterator.remove();
      }
    }
    //打印
    list.forEach(System.out::println);
    
    //四：使用lambda表达式-jdk1.8
    list.removeIf("c"::equals);
    //打印
    list.forEach(System.out::println);
  
    Supplier<Son> sonSupplier = Son::new;
    Son son = sonSupplier.get();
    
    
  }
}

package com.example.demo.other;

import com.example.demo.annotation.Test;

/**
 * 字符串判断
 * @author byron
 * @date 2018/12/25 11:34
 */
@Test("haha")
public class Test5 {

//  private static final String AAA = "hello";
  public static void main(String[] args) {
//    Test test = Test5.class.getAnnotation(Test.class);
//    System.out.println(test.value());

//    String a1 = new String("hello");
//    String a3 = a1.intern();
//    System.out.println(a==a1);
//    System.out.println(a==a3);


    String a = "hello";
    String b = "he"+"llo";
    String str = new StringBuilder().append("hel").append("lo").toString();
  //  String str = new String("hello'");
    System.out.println(a == b);
    System.out.println(b == str);
    System.out.println(str == a );
    String str2 = new StringBuilder("ja").append("va").toString();
    //在常量池中没有"hello"这个常量，所以在new的时候会创建两个。一个存放在常量池，另外一个存放在堆中。所以这两个对象是同一个地址。所以结果为true
    System.out.println(str.intern() == str);
    //由于"java"在class加载的时候就已经存在了（具体存在位置在Version这个类里）。所以new的时候只会创建一个。存放在堆中，
    // 所以这两个地址是不同的两个地址
    System.out.println(str2.intern() == str2);

  }
}

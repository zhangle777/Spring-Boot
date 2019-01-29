package com.example.demo.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.Timer;

/**
 * @author byron
 * @date 2019/1/23 11:16
 */
public class Test {

  public static void main(String[] args) {
    Timer timer = new Timer(1000,it->System.out.println(it));
//    timer.start();
    List<String> list = Arrays.asList(new String[]{"b","a","c"});
    //方法引用
    Collections.sort(list,String::compareTo);
    System.out.println(list);
    TestA testA = new TestA();
    testA.getA(()->{System.out.println();return "a";});


  }

}

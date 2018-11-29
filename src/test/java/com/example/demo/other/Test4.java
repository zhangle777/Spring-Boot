package com.example.demo.other;

import java.util.HashMap;
import java.util.Map;
import sun.applet.Main;

/**
 * @author byron
 * @date 2018/11/16 10:25
 */
public class Test4 implements InterfaceA {

  //

  @Override
  public void test() {
    final String name = "sd";
    System.out.println(name);
  }
//  @Override
//  public void test2() {
//    System.out.println(ss);
//    System.out.println(ddd);
//    System.out.println();
//  }

  public static void main(String[] args) {

    System.out.println(2&3);
    Map<String,String> m = new HashMap<>();
    m.put("a", "rrr1");
    m.put("b", "tt9");
    m.put("c", "tt8");
    m.put("d", "g7");
    m.put("e", "d6");
    System.out.println(m.get("a"));
  }
}

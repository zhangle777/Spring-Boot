package com.example.demo.other;

/**
 * @author byron
 * @date 2018/12/28 17:52
 */
public class Test6 extends test7{
  static {
    System.out.println("dfsfsdfs");
  }
}
class AAA{
  public static void main(String[] args) {
    //String string = new StringBuilder("AA").append("AA").toString();
    String string = new String("AAAA");
    String string1 = string.intern();
    String string2 = "AAAA";

//    System.out.println(string2 == string);
//    System.out.println(string1 == string);
    System.out.println(string1 == string2);
    System.out.printf("%1.2f",11.2102);
    System.out.println(Test6.string);
  }
}

class test7{
  public static String string = "ddd";
  static {
    System.out.println("12312分公司答复");
  }
}

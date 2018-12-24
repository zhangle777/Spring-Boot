package com.example.demo.other;


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
  public static Integer test2(int x){

    try{
      x++;
      return x;
    } catch (Exception e){
      x=2;
    }finally {
      x=3;
      return x;
    }

  }

  public static void main(String[] args) {
    String reg = "[\\u4e00-\\u9fa5a-zA-Z]+";
    String reg2 = "^\\d*$";
    System.out.println("a10123186".matches(reg2));
//    String a = "abc";
//    a = "bcd";
//    String a1 = "abc";
//    String a2 = new String(a);
//    System.out.println(a1 == a2);

//    System.out.println(2&3);
//    Map<String,String> m = new HashMap<>();
//    m.put("a", "rrr1");
//    m.put("b", "tt9");
//    m.put("c", "tt8");
//    m.put("d", "g7");
//    m.put("e", "d6");
//    System.out.println(m.get("a"));
  }
}

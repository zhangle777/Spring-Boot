package com.example.demo.other;

public class Test8 extends AbstractA implements InterfaceA{
 private static int i;
 private int i1;
 
 static{
   System.out.println(i+"haha");
 }
 
  {
    System.out.println(i1);
  }
  
  public static void main(String[] args) {
    AbstractA test8 = new Test8();
  }
}


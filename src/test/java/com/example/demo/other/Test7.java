package com.example.demo.other;

public class Test7 {
  public static void main(String[] args) {
    char c1 = 40;
    char c2 = 41;
    char c3 = '(';
    char c4 = ')';
    char c5 = '('+')'+'2';
    char c6 = c3;
    
    int i = c3+'s';
    System.out.println(i);
    
    System.out.println("c1："+c1); //输出40对应的ASCII编码。也就是"("
    
    System.out.println("c2："+c2); //输出41对应的ASCII编码。也就是")"
  
    System.out.println("c3："+c3);
  
    System.out.println("c4："+c4);
    
    System.out.println("c5："+c5); //1.首先将"("和")"转为对应的十进制，也就是40和41。
                            //2.然后再将十进制的数相加，为81。
                            //3.然后再将81转为对应的ASCII编码。输出
    
    System.out.println(c1+c2); //将c1和c2分别转为十进制 对应为40和41，然后再相加为int型。输出
  
    System.out.println((char)c1+c2);
    
    //总结: 1.char类型用于存储一个字符。占2个字节。
    //      2.对char类型变量赋数值时，会自动转换成ASCII编码输出。char类型字面量进行运算时，会先自动转换为ASCII数值，再运算，最后再转为ASCII字符。
    //      3.
  }
}

/**
 * Copyright (C), 2015-2018, XXX有限公司 FileName: Son Author:   byron Date:     2018/8/10 17:05
 * Description: History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.other;

public class Son extends Person{
  public String sdf = "ddss";
  public String str = "2";
  public String fustr = super.str;
  public static final String DD = "sss";
  public void test(){

  }

  public static void main(String[] args) {
    Long i = new Long(1);
    long i1 = new Long(1);
    System.out.println(i==(i1));
  }
}

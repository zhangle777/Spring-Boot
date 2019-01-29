package com.example.demo.InnerClass;

/**
 * 内部类测试
 * @author byron
 * @date 2019/1/29 13:03
 */
public class InnerClassTest {
  private String name;

  public Inner inner;
  public InnerClassTest(String name) {
    this.name = name;
  }

  public Inner getInner(){
    if(inner == null)
      inner = new Inner();
    return  inner;
  }

  private class Inner{
    private String innerName;
    private String name;
    public void test(){
      System.out.println(InnerClassTest.this.name);
    }

  }
}

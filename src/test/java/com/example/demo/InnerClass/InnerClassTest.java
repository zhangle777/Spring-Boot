package com.example.demo.InnerClass;

/**
 * 内部类测试
 * @author byron
 * @date 2019/1/29 13:03
 */
public class InnerClassTest {
  private String name;
  public Inner inner;
  public static String AAA = "的身份";
  
  interface AA{
    int abc();
  }
  
  public static AA staticTest(){
    /**
     * 匿名内部类
     * 1.匿名内部类是直接使用new来生成一个对象的引用
     * 2.匿名内部类只能使用一次，创建一个匿名内部类时会立即创建一个该类的实例。
     * 3.匿名内部类中不能定义构造函数，匿名内部类中不能存在任何静态成员变量以及静态方法。
     * 4.匿名内部类不能是抽象的，它必须要实现继承的类，或者实现的接口的所有抽象方法。
     */
    return new AA() {
      @Override
      public int abc() {
        return 0;
      }
    };
  }
  
  public void getInner(){
    int a1 = 2;
    /**
     * 局部内部类
     * 1.方法内部类的作用域仅限于方法内部，方法外部无法访问方法内部类。
     * 2.方法内部类不能有public、protected、private以及static等修饰符 但是可以用final修饰和abstract修饰符。
     * 3.方法内部类不能改变方法局部变量的值。因为在jdk1.8之后。方法内部类中访问的方法局部变量默认都是final类型。
     *   在jdk1.8之前则必须加上final。
     */
    class Demo{
      int a = 2;
      public int test(int a){
        return ++a;
      }
    }
    Demo demo = new Demo();
    demo.test(a1);
    System.out.println(demo.a);
  }
  
  
  /**
   * 定义成员内部类
   *
   * 1.成员内部类相当于外部类的一个成员属性，可以使用任何访问修饰符
   * 2.成员内部类可以访问外部类的成员变量(方法)和静态变量(方法)。而不受访问修饰符的影响。访问静态变量：外部类.变量名(方法)。访问成员变量：外部类.this.变量名(方法)
   * 3.成员内部类不能直接使用new关键字创建对象，必须要先创建外部类对象。原理同成员变量一致。例：内部类 对象名=外部内对象.new.内部类()
   * 4.当编译含有内部类的类文件时，会产生两个多个class文件。
   * 5.成员内部类不能含有静态变量以及静态方法。原理普通成员方法(因为成员内部类要等外部类实例化后才能实例化。违背静态原理)。但可以定义常量
   */
  public class Inner{
    public final String aaa = "";
    private String innerName;
    private String name;
  
    public void test(){
      System.out.println(InnerClassTest.AAA);
      InnerClassTest.staticTest();
      System.out.println(InnerClassTest.this.name);
    }
  }
  
  /**
   * 静态内部类
   * 1.静态内部类相当于外部类的一个静态属性。可以使用任意访问修饰符。
   * 2.静态内部类不能直接访问外部类的成员属性以及方法。原理同静态变量一致。必须先构造外部类对象。例：new 外部类().变量名
   * 3.静态内部类访问外部类的静态成员时，可直接调用外部类的成员名(当外部类的静态成员名称与内部类的实例成员名称不同时)。如果相同则需用外部类.变量名
   * 4.创建静态内部类时，不需要外部类对象。可直接：内部类 对象名 = new 内部类()
   */
  private static class staticInner{
    private String innerName;
    private String AAA;
    private static String svar = "商贷栓";
    public static void staticTest(){
      System.out.println(InnerClassTest.AAA);
      System.out.println(new InnerClassTest().name);
    }
    public void test(){
      System.out.println(AAA);
    }
  }
  
  public static void main(String[] args) {
    InnerClassTest test = new InnerClassTest();
    test.getInner();
  }
}

package com.example.demo.genericity;

import java.io.Serializable;

/**
 * 自定义泛型类
 * @author byron
 * @date 2019/2/18 9:23
 */
public class Person<T> {

  private T min;
  private T max;

  public Person() {
    min = null;
    max = null;
  }

  public Person(T min, T max) {
    this.min = min;
    this.max = max;
  }

  public T getMin() {
    return min;
  }

  public void setMin(T min) {
    this.min = min;
  }

  public T getMax() {
    return max;
  }

  public void setMax(T max) {
    this.max = max;
  }

  /**
   * 泛型方法
   * 1.类型变量应该在访问修饰符的后面，返回类型的前面
   * 2.T表示类型变量。<T extends Comparable> 表示T是Comparable的子类型，这里用extends关键字更加形象。
   * 3.<T extends Comparable> Comparable是它的限定类型。可以是接口，也可以是类。可以有多个限定类型。比如：
   * <T extends Comparable & Serializable> 用 & 符连接,限定类型至多只能有一个类。可以有多个接口。一般类放在前面。
   * 4.多个类型变量可以用“,” 隔开。
   * @param array
   * @param <T>
   * @return
   */

  public static <T extends Comparable & Serializable> Person<T> test(T[] array){
    T min = array[0];
    T max = array[0];
    for(int i = 1; i<array.length;i++){
      if(max.compareTo(array[i])<0)
        max = array[i];
      if(min.compareTo(array[i])>0)
        min = array[i];
    }
    return new Person<>(min,max);
  }
}

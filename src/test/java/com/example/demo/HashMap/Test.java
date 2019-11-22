package com.example.demo.HashMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * HashMap的lambda表达式练习
 */
public class Test {
  
  public static void main(String[] args) {
    HashMap<String,String> hashMap = new HashMap<>();
    hashMap.put("name","张乐");
    hashMap.put("class","二年级");
    //getOrDefault()方法 表示获取key对应的值，如果不存在这个key。则返回默认值。
    String name = hashMap.getOrDefault("name","没有名字就用默认值");
    System.out.println(name);
    //遍历
    hashMap.forEach((key,value)->{
      System.out.print(key+",");
      System.out.println(value);
    });
    System.out.println("=============");
  
    List<Student> students = new ArrayList<>();
    students.add(new Student("张三","男",18));
    students.add(new Student("李四","男",20));
    students.add(new Student("韩梅梅","女",18));
    students.add(new Student("小红","女",45));
    
    //computeIfAbsent()方法表示如果key对应的value存在，则返回value，如果不存在则会将第二个参数的返回值存入并返回
    HashMap<String,List<Student>> stuMap = new HashMap<>();
    students.forEach(item->{
      List<Student> list = stuMap.computeIfAbsent(item.getSex(),k->new ArrayList<>());
      list.add(item);
    });
    System.out.println(stuMap);
  }
  
}
class Student{
  
  public Student(String name, String sex,int age) {
    this.name = name;
    this.age = age;
    this.sex = sex;
  }
  
  private String name;
  
  private int age;
  
  private String sex;
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getAge() {
    return age;
  }
  
  public void setAge(int age) {
    this.age = age;
  }
  
  public String getSex() {
    return sex;
  }
  
  public void setSex(String sex) {
    this.sex = sex;
  }
  
  @Override
  public String toString() {
    return "{name="+name+",sex="+sex+",age="+age+"}";
  }
}
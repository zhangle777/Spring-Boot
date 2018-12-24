package com.example.demo.other;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.util.Lists;

/**
 * @author byron
 * @date 2018/10/31 16:15
 */
public class Test3 {

  public static void test(){
    List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9);
    List<Integer> list2;
    list2 = list.stream().peek(item->System.out.println("list="+item)).map(n->n*n).collect(
        Collectors.toList());
    list2.forEach(item->System.out.println("list2的"+item));
    Stream.of(1,2,3,4,2);
  }

//  public static void main(String[] args) {
//    test();
//  }

  //小明
  public static void xiaoming(){

    int salary = 1; // 每天的工资
    int money = 1;
    int i;
    for(i = 0;money<108;i++){
      money += salary;
      salary += 2;

    }
    System.out.println("共需要"+i+"天");
  }

  //猴子
  public static void houzi(){
    for(int k = 6;k<10000;k++){
      //设定有6支香蕉
      float total = (float) k;
      for(int i = 1;i<=4;i++){
        float a = total-i;//i表示被猴子吃掉剩下的那一份
        float b = a/(float) 5.0;//b表示每只猴子吃掉自己的那一份
        total = a-b;//第一支猴子吃掉并藏起来后剩下的总数。依次类推
      }
      //当前面四只都吃完了自己的后。第五只猴子能够均分
      if(total >0 && total%5 == 0){
        System.out.println("一共"+k+"只");
        break;
      }
    }
  }

  //第几个幸运数
  public static void luckyNum(){
    long d = 0;
    long target = 59084709587505l;
    for(long i = 3;i<=target;i++){
    }
    System.out.println("第"+d+"个");

  }

  public static void main(String[] args) {
    xiaoming();
  }

}

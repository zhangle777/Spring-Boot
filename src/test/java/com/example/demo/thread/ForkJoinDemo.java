package com.example.demo.thread;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.function.DoublePredicate;

/**
 * ForkJoin框架demo
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {
  //阈值
  private static final int THRESHOLD = 100;
  
  private Double[] value;
  
  private int form;
  
  private int to;
  
  private DoublePredicate filter;
  
  public Double[] getValue() {
    return value;
  }
  
  public void setValue(Double[] value) {
    this.value = value;
  }
  
  public int getForm() {
    return form;
  }
  
  public void setForm(int form) {
    this.form = form;
  }
  
  public int getTo() {
    return to;
  }
  
  public void setTo(int to) {
    this.to = to;
  }
  
  public DoublePredicate getFilter() {
    return filter;
  }
  
  public void setFilter(DoublePredicate filter) {
    this.filter = filter;
  }
  
  public ForkJoinDemo(Double[] value, int form, int to, DoublePredicate filter) {
    this.value = value;
    this.form = form;
    this.to = to;
    this.filter = filter;
  }
  
  
  
  @Override
  protected Integer compute() {
//    System.out.println(Thread.currentThread().getName() + ": ∑(" + start + "~" + end + ")=" + sum);
    return null;
  }
}

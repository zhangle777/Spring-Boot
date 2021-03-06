package com.example.demo.thread;

import java.util.Random;

/**
 * 模拟用户的线程类
 */
public class BankTest implements Runnable{

  public static final int NACCOUNTS = 10; //模拟创建100个用户
  
  public static final int INITBALANCE = 1000;
  
  public static final int MAXBALANCE = 1000;//如果这里设置为2000，就会出现死锁的情况
  public static final Random RANDOM = new Random();
  private Bank bank;
  
  private int from;
  
  private int to;
  
  public BankTest(Bank bank,int from,int to) {
    this.bank = bank;
    this.from = from;
    this.to = to;
  }
  
  @Override
  public void run(){
    try {
      while (true){
        int amount = RANDOM.nextInt(MAXBALANCE);
        bank.transfer(from,to,amount);
        Thread.sleep(10);
      }
    }catch (InterruptedException e){
    }
   
  }
  
  public static void main(String[] args) {
    Bank bank = new Bank(NACCOUNTS,INITBALANCE);//创建一个银行类。初始化100个用户。
    for(int i = 0; i<NACCOUNTS;i++){
      //返回一个0，2之间的随机数。
      int to = RANDOM.nextInt(NACCOUNTS);
      BankTest bankTest = new BankTest(bank,i,to);
      Thread thread = new Thread(bankTest);
      thread.start();
    }
  }
  
//  public static void main(String[] args) {
//    for(int i = 0;i<100;i++){
//      System.out.println(RANDOM.nextInt(NACCOUNTS));
//    }
//  }
}

package com.example.demo.thread;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟多个账户转钱的过程。
 * 银行类
 */
public class Bank {
  private final int[] accounts;// 初始化账户数组
  
  private final Lock lock = new ReentrantLock();//给银行类维护一个锁对象(可重入锁)
  
  private final Condition condition = lock.newCondition();
  
  public Bank(int n,int initBalance) {
    this.accounts = new int[n];
    Arrays.fill(accounts,initBalance);//填充数组
  }
  
  /**
   * 转账过程方法
   * 总结：
   * 锁对象：使用锁对象可以保证线程同步，任何时刻只有一个线程A进入该区域，一旦该区域被锁定，其他线程无法通过该区域，他们进入阻塞状态
   *        直到线程A释放锁对象。（注意：解锁动作应该放在finally子句中，如果再临界区抛出异常。该线程必须解锁。否则其他线程将永远阻塞）。
   *        new ReentrantLock对象是一个可重入锁，也就是说如果在该锁的临界区类还调用了一个方法，那么该锁持有的计数器会+1，
   *        当退出该方法时，计数器则会-1。当退出最外层方法时，计数器为0。线程释放锁
   *
   * 条件对象（条件变量）：条件对象用来管理已经获得了锁但是却不能做有用工作的线程。只有满足条件的线程才能继续执行。如果不满足则进入阻塞状态
   *        这里用来判断如果某用户余额少于转账金额，则不能继续转账。而是等待其他线程往银行总金额充入才能继续操作。
   * 关键之处：1.锁用来保护代码片段，任何时刻只能有一个线程执行被保护的代码
   *          2.锁可以管理试图进入被保护代码的线程。
   *          3.锁可以拥有一个或多个相关的条件对象。
   *          4.每个条件管理那些已经进入被保护代码段但还不能运行的线程
   * @param from
   * @param to
   * @param amount
   */
  public void transfer(int from,int to,int amount){
    lock.lock();
    //临界区
    try {
      while (accounts[from] < amount) {
        System.out.println("当前转出账户为：" + from + ",该账户余额为："+accounts[from]+",转出" + amount + "余额不足");
        //如余额不足时，该线程进入条件等待池。并且放弃锁。以供其他线程能够访问。
        // 而该线程则必须等待其他线程调用signalAll()方法唤醒它。当被唤醒后，则从被阻塞的地方继续执行，这里还会继续检查账户的余额。
        condition.await();
      }
      System.out.print(Thread.currentThread());
      accounts[from] -= amount;
      System.out.print("从" + from + "账户转出" + amount + ",");
      accounts[to] += amount;
      System.out.println(to + "账户收到" + amount + ",总资金为:" + total());
      //当其他线程吧钱转到被阻塞的线程账户中，会唤醒所有等待的线程。
      //注意：还有一个signal()方法。表示随机解除等待池中某个线程的阻塞状态。
      condition.signalAll();
    }catch(InterruptedException e){
    }
    finally {
      lock.unlock();//解锁，以供其他线程能够访问该方法
    }
  }
  
  /**
   * synchronized 关键字：
   * 从1.0版本开始，java中的每个对象都有一个内部锁，使用synchronized关键字修饰方法，那么对象的锁将保护整个方法。
   * 要调用该方法，线程必须获得内部对象锁。
   * synchronized关键字修饰静态方法时，所获得的锁是类对象的内部锁。
   * 注意：wait方法和notifyAll/notify方法必须在同步方法或同步代码块中使用。
   * 如果当前线程不是对象锁的持有者，则抛出IllegalMonitorStateException异常
   * @param from
   * @param to
   * @param amount
   */
  public synchronized void transfer2(int from,int to,int amount){
    try{
      while (accounts[from] < amount) {
        System.out.println("当前转出账户为：" + from + ",该账户余额为："+accounts[from]+",转入" + amount + "余额不足");
        //使用wait方法是该线程进入等待池，并放弃锁。必须等待其他线程调用notifyAll/notify方法唤醒该线程。等价与条件对象的await方法
        wait();
      }
      System.out.print(Thread.currentThread());
      accounts[from] -= amount;
      System.out.print("从" + from + "账户转出" + amount + ",剩余"+accounts[from]+",");
      accounts[to] += amount;
      System.out.println(to + "账户收到" + amount + "，剩余为"+accounts[to]+",总资金为:" + total());
      //使用notify/notifyAll方法唤醒在等待池的阻塞线程。该方法只能在同步方法或同步代码块中使用。
      notifyAll();
    }catch (InterruptedException e){
    }
  }
  
  private int total(){
    int sum = 0;
    for(int a : accounts)
      sum += a;
    return sum;
  }
  
  public int size(){
    return accounts.length;
  }
}

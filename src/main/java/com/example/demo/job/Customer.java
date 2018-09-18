/**
 * Copyright (C), 2015-2018, XXX有限公司 FileName: Customer Author:   byron Date:     2018/8/16 16:19
 * Description: History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.job;

import com.example.demo.config.RunAfterExecutor;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 消费者
 */
public class Customer implements Runnable{

  private LinkedBlockingQueue linkedBlockingQueue = RunAfterExecutor.linkedBlockingQueue;

  @Override
  public void run() {
    while (true){
      try {
        String string = (String) linkedBlockingQueue.take();
        System.out.println(Thread.currentThread()+"消费者消费"+string);
      }catch (InterruptedException e){
        e.printStackTrace();
      }finally {
        try{
          Thread.sleep(2000);
        }catch (Exception e){
          e.printStackTrace();
        }
      }
    }
  }
}

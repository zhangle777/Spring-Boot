package com.example.demo.job;

import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

/**
 * 动态定时任务服务（可以在运行时修改间隔时间）
 * @author byron
 * @date 2018/12/28 11:46
 */
//@Configuration
@EnableScheduling
public class SpringDynamicTask implements SchedulingConfigurer{

  public static int job=1;
  private static String cron;
  public SpringDynamicTask() {
    new Thread(()->{
      System.out.println("当前线程"+Thread.currentThread());
        cron = "0/5 * * * * ?";
        try {
         Thread.sleep(15*1000);
        }catch (InterruptedException e){
          e.printStackTrace();
        }
        cron = "0/2 * * * * ?";
        System.err.println("cron change to: " + cron);
    }).start();
  }

  @Override
  public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    taskRegistrar.addTriggerTask(()->
      System.err.println("当前线程："+Thread.currentThread()+"，动态定时任务启动,当前时间为:"+ LocalDateTime.now()+"，当前次数为"+job++)
    ,(triggerContext)->{
          CronTrigger trigger = new CronTrigger(cron);
          Date nextExec = trigger.nextExecutionTime(triggerContext);
          return nextExec;
    });
  }
}

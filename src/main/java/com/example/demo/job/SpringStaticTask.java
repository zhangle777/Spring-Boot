package com.example.demo.job;

import java.time.LocalDateTime;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * 静态定时任务服务（不能再运行状态修改间隔时间）
 */
@Configuration
@EnableScheduling
public class SpringStaticTask {
  public int job = 1;
  //@Scheduled(cron = "0/1 * * * * ? ")
  public void job(){
    //你要做的什么事
    System.out.println("当前线程："+Thread.currentThread()+"，静态定时任务启动,当前时间为:"+ LocalDateTime.now()+"，当前次数为"+job++);
  }


}

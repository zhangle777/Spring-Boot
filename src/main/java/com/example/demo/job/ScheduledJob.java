/**
 * Copyright (C), 2015-2018, XXX有限公司 FileName: ScheduledJob Author:   byron Date:     2018/8/16
 * 15:27 Description: History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.job;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledJob {
  public int job = 1;
  public int job2 = 1;
  public int job3= 1;
//  @Scheduled(cron = "0/1 * * * * ? ")
  public void job(){
    System.out.println("当前线程："+Thread.currentThread()+"，定时任务job1启动,当前时间为:"+LocalDateTime.now()+"，当前次数为"+job++);
  }
}

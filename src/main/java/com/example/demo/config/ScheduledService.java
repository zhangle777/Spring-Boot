package com.example.demo.config;

import java.util.concurrent.Executors;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * 定时任务服务
 */
@Configuration
public class ScheduledService implements SchedulingConfigurer {

  @Override
  public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
    scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));
    System.out.println("+++++启动定时服务成功+++++");
  }
}

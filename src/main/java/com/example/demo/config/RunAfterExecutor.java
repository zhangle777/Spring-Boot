package com.example.demo.config;

import com.example.demo.job.Customer;
import java.util.concurrent.LinkedBlockingQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:config/config.properties",encoding = "utf-8")
public class RunAfterExecutor implements ApplicationRunner {
  @Value("${customerNum}")
  private Integer customerNum;

  public static final LinkedBlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue<>();

  @Override
  public void run(ApplicationArguments args) {
    for(int i = 1;i <= customerNum;i++){
      Thread customerThread = new Thread(new Customer(),"customer线程"+i);
      customerThread.start();
      System.out.println(customerThread.getName()+"启动成功");
    }
  }
}

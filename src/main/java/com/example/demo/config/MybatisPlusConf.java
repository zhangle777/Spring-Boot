package com.example.demo.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.demo.dao.*")
public class MybatisPlusConf {

  @Bean
  public PaginationInterceptor paginationInterceptor(){
      PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
      return paginationInterceptor;
  }
}

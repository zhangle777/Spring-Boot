package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceService implements ResourceServerConfigurer {
  
  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
  
  }
  
  @Override
  public void configure(HttpSecurity http) throws Exception {
//      //资源认证
//    http.antMatcher("/student/**") //表示/student路径下所有接口都需要认证
//        .authorizeRequests()
//        .anyRequest().authenticated();
    http
        .requestMatchers()
        .antMatchers("/order/**")
        .and()
        .authorizeRequests()
        .anyRequest()
        .authenticated();
  }
}

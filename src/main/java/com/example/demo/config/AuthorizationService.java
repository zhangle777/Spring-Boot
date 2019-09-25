package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * 授权服务配置
 * @EnableAuthorizationServer 开启授权服务
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationService implements AuthorizationServerConfigurer {
  
  //注入密码加密bean
  @Autowired
  PasswordEncoder passwordEncoder;
  
  @Autowired
  AuthenticationManager authenticationManager;
  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    security
        .tokenKeyAccess("permitAll()")
        .checkTokenAccess("isAuthenticated()") //allow check token
        .allowFormAuthenticationForClients();
  }
  
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory()
        .withClient("client")
        .secret(passwordEncoder.encode("123456"))
        .scopes("app")
        .authorizedGrantTypes("password")
        .redirectUris("http://localhost:8089/index");
  }
  
  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
      endpoints.authenticationManager(authenticationManager);
      //允许 GET、POST 请求获取 token，即访问端点：oauth/token
      endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
  }
}

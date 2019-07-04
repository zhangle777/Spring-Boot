package com.example.demo.config;

import com.example.demo.security.UserDetailsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;


/**
 * @author byron
 * @date 2018/12/19 16:56
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private UserDetailsServiceImpl userDetailsService;
  @Autowired
  private ObjectMapper objectMapper;
  
  
  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
  
  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider
        = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService);
    authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
    return authProvider;
  }
  
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.formLogin()
        .loginPage("/loginPage")
        .loginProcessingUrl("/login")
//        .successHandler(loginSuccessHandler())
        .successForwardUrl("/index")
        .failureUrl("/loginErrorPage")
        .and()
        .authorizeRequests()
        .antMatchers("/registerPage","/register","/loginPage","/loginErrorPage","/static/**")
        .permitAll()  //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
        .anyRequest().authenticated()
        .and()
        .csrf().disable();
  }
  
  @Bean
  public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler() { //登入处理
    return new SavedRequestAwareAuthenticationSuccessHandler() {
      @Override
      public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User userDetails = (User) authentication.getPrincipal();
        request.setAttribute("user",userDetails.getUsername());
        logger.info("USER : " + userDetails.getUsername() + " LOGIN SUCCESS !  ");
        super.onAuthenticationSuccess(request, response, authentication);
      }
    };
  }
}

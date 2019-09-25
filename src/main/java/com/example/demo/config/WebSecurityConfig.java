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
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;


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
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }


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
    http
        //暂时禁用csrc否则无法提交
        .csrf()
        .disable()
        // 设置最多一个用户登录，如果第二个用户登陆则第一用户被踢出，并跳转到登陆页面
        .sessionManagement().maximumSessions(1).expiredUrl("/index");
    //表单登陆
    http
        .formLogin()
        .loginPage("/loginPage") // 设置跳转的登陆页面
        .loginProcessingUrl("/login")
//        .defaultSuccessUrl("/index")
        .successHandler(loginSuccessHandler())
        .failureUrl("/loginErrorPage");//设置如果出错跳转到哪个页面
    //资源认证
    http
        .authorizeRequests() //表示这个Adapter会匹配所有请求。然后这些请求中按照下面的匹配规则过滤。
        .antMatchers("/registerPage","/register","/loginPage","/loginErrorPage","/static/**")//静态资源不验证
        .permitAll()  //permitAll()表示这个不需要验证 登录页面，登录失败页面
        .anyRequest().authenticated();
    //登出
    http
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/loginPage")
        .invalidateHttpSession(true);
  }

  public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler() { //登入处理
    return new SavedRequestAwareAuthenticationSuccessHandler() {
      @Override
      public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        String name = authentication.getName();
        if (header == null || !header.startsWith("Basic ")) {
          throw new UnapprovedClientAuthenticationException("请求头中无client信息");
        }
        logger.info("Success hanlder"); //这里加入需要的处理
        String  redirectUrl = "index"; //缺省的登陆成功页面
        SavedRequest savedRequest = (SavedRequest) request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
        if(savedRequest != null && !savedRequest.getRedirectUrl().equals("http://localhost:8089/")) {
          redirectUrl =   savedRequest.getRedirectUrl();
          request.getSession().removeAttribute("SPRING_SECURITY_SAVED_REQUEST");
        }
        response.sendRedirect(redirectUrl);
      }
    };
  }
}

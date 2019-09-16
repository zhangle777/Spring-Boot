package com.example.demo.security;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
  
  @Autowired
  private UserService userService;
  
  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    User user = userService.selectOne(new EntityWrapper<User>().eq("username",s));
    return new CustomUser(s,user.getPassword(),user.getNickName(),user.getId(),AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
  }
}

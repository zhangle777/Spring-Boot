package com.example.demo.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
  
  private Long userId;
  
  private String nickName;
  
  public Long getUserId() {
    return userId;
  }
  
  public String getNickName() {
    return nickName;
  }
  
  public void setUserId(Long userId) {
    this.userId = userId;
  }
  
  public void setNickName(String nickName) {
    this.nickName = nickName;
  }
  
  public CustomUser(String username, String password,
      String nickName, Long userId, Collection<? extends GrantedAuthority> authorities) {
    super(username, password, authorities);
    this.nickName = nickName;
    this.userId = userId;
  }
}

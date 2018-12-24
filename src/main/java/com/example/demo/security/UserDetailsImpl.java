package com.example.demo.security;

import com.example.demo.pojo.Role;
import com.example.demo.pojo.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author byron
 * @date 2018/12/19 10:42
 */
public class UserDetailsImpl implements UserDetails {


  private String userName;
  private String password;
  //包含着用户对应的所有Role，在使用时调用者给对象注入roles
  private List<Role> roles;

  public void setUsername(String username) {
    this.userName = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    for(Role role : roles) {
      authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
    }
    return authorities;
  }

  public UserDetailsImpl(User user, List<Role> roles) {
    this.userName = user.getUserName();
    this.password = user.getPassword();
    this.roles = roles;
  }

  public UserDetailsImpl() {}

  public UserDetailsImpl(User user) {
    this.userName = user.getUserName();
    this.password = user.getPassword();
  }



  @Override
  public String getPassword() {
    return null;
  }

  @Override
  public String getUsername() {
    return null;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}

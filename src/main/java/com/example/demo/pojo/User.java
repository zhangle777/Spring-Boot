/**
 * Copyright (C), 2015-2018, XXX有限公司 FileName: User Author:   byron Date:     2018/8/16 16:36
 * Description: History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.pojo;

public class User {

  private Long id;

  private String username;

  private String password;

  private String nickName;
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getNickName() {
    return nickName;
  }
  
  public void setNickName(String nickName) {
    this.nickName = nickName;
  }
  
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}

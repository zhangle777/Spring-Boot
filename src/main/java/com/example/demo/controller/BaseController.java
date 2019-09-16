package com.example.demo.controller;

import com.example.demo.security.CustomUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseController {

  protected CustomUser getUser(){
    Authentication authentication =SecurityContextHolder.getContext()
        .getAuthentication();
    Object principal = authentication.getPrincipal();
    if(principal instanceof String){
      return null;
    }else{
      return (CustomUser)principal;
    }
  }
}

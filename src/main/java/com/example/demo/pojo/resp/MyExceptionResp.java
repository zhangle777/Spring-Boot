/**
 * Copyright (C), 2015-2018, XXX有限公司 FileName: MyExceptionResp Author:   byron Date:     2018/8/17
 * 16:24 Description: History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.pojo.resp;

public class MyExceptionResp {

  private Integer code;
  private String message;

  public MyExceptionResp(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}

package com.example.demo.constant;

/**
 * @author byron
 * @date 2018/8/28 9:00
 */
public class Constants {
  public static final  long COOKIE_MAX_AGE = 60 * 60 * 24 * 7 * 4L; // 默认cookie保存4个星期

  /**
   * 字段注释
   * 登陆验证秘钥key
   */
  public static final String LOGIN_KEY = "WITH_LOGIN_VERIFY_KEY";

  /**
   * 字段注释
   * cookie自动登陆保存key
   */
  public static final String LOGIN_COOKIE_SIGN = "with_cookie_sign";

  //存储用户对象的sessionkey
  public static final  String WITH_SESSION_USER = "withSessionUser";

}

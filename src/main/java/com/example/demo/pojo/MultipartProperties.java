package com.example.demo.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author byron
 * @date 2018/9/3 10:26
 */
@Component
@ConfigurationProperties(prefix = "multipart-properties")
public class MultipartProperties {

  /**
   * 前缀
   */
  private String filePathPrefix;

  /**
   * 后缀
   */
  private String filePathSuffix;

  public String getFilePathPrefix() {
    return filePathPrefix;
  }

  public void setFilePathPrefix(String filePathPrefix) {
    this.filePathPrefix = filePathPrefix;
  }

  public String getFilePathSuffix() {
    return filePathSuffix;
  }

  public void setFilePathSuffix(String filePathSuffix) {
    this.filePathSuffix = filePathSuffix;
  }
}

package com.example.demo.annotation;

import com.example.demo.pojo.MultipartProperties;
import com.example.demo.util.SpringUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author byron
 * @date 2018/9/3 10:06
 */
@Component
public class UrlPrefixSerialize extends JsonSerializer<Object> {

  @Autowired
  private MultipartProperties multipartProperties;
  @Override
  public void serialize(Object o, JsonGenerator jsonGenerator,
      SerializerProvider serializerProvider) throws IOException {
    String value = (String) o;
    jsonGenerator.writeString(multipartProperties.getFilePathPrefix()+value);
  }
}

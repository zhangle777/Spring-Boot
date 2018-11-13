package com.example.demo.resolver;

import java.util.Collections;
import java.util.Set;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

/**
 * 自定义类型转换
 * @author byron
 * @date 2018/10/31 9:42
 */
public class MyConverter implements ConditionalGenericConverter {

  @Override
  public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
    return false;
  }

  @Override
  public Set<ConvertiblePair> getConvertibleTypes() {
    return Collections.singleton(new ConvertiblePair(String.class,String.class));
  }

  @Override
  public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {

    return null;
  }
}

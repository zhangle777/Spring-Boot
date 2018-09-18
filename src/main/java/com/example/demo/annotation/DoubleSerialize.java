package com.example.demo.annotation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * @author byron
 * @date 2018/8/31 15:32
 */
public class DoubleSerialize extends JsonSerializer<Double> {

  private DecimalFormat df = new DecimalFormat("##.0000");


  @Override
  public void serialize(Double aDouble, JsonGenerator jsonGenerator,
      SerializerProvider serializerProvider) throws IOException {

    jsonGenerator.writeString(df.format(aDouble));
  }
}

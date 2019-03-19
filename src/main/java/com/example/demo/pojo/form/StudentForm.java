/**
 * Copyright (C), 2015-2018, XXX有限公司 FileName: StudentForm Author:   byron Date:     2018/8/17 13:46
 * Description: History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.pojo.form;

import com.example.demo.pojo.Student;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StudentForm extends Student {

  @Override
  public Integer getId() {
    return super.getId();
  }

  @NotBlank
  @Override
  public String getName() {
    return super.getName();
  }

  @NotNull
  @Override
  public Integer getAge() {
    return super.getAge();
  }

  @NotNull
  @Override
  public Double getSalary() {
    return super.getSalary();
  }
}

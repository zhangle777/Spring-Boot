/**
 * Copyright (C), 2015-2018, XXX有限公司 FileName: TestController Author:   wangpengfei Date:
 * 2018/7/19 10:13 Description: History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.config.TestConfig;
import com.example.demo.pojo.Person;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.form.StudentForm;
import com.example.demo.service.StudentService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController{

  @Autowired
  public StudentService studentService;
  @Autowired
  public TestConfig testConfig;
  @Autowired
  public Person person;

  @GetMapping("/info")
  public Object getStudentInfo(@RequestParam(value = "id") Integer id){
    Student student = studentService.selectById(id);
//    studentService.updateById()
    return student;
  }

  @GetMapping("/list")
  public Object getStudentListPage(Page<Student> page,Student student,String orderBy,
      @RequestParam(defaultValue = "asc",required = false) String sort){
    boolean b = true;
    if(sort =="desc")
      b = false;
    return studentService.getStudentPage(page,student,orderBy,b);
  }

  @GetMapping("insert")
  public Object insertStudent(StudentForm studentForm){
    studentService.insert(studentForm);
    Map<String,Object> result = new HashMap<>();
    return result;

  }

  @GetMapping("/testCustomer")
  public Object testCustomer(String string){
    for(int i = 0;i<20;i++){
      studentService.insertToQueue(string);
    }
    return new HashMap<>();
  }
  @GetMapping("/person")
  public Object person(){
    System.out.println(testConfig.getName());
//    throw new MyCustomException("哈啊啊是个");
//    Assert.hasText("","玩你大爷");
//
//    return null;
//    return null;
    return person.getName()+"+++++++"+person.getAge()+"======"+person.getAddress();
  }

}

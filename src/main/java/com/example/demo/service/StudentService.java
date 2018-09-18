package com.example.demo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.example.demo.pojo.Student;

public interface StudentService extends IService<Student> {

  Page<Student> getStudentPage(Page<Student> page,Student student,String orderBy,boolean sort);

  void insertToQueue(String string);
}

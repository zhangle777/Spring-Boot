/**
 * Copyright (C), 2015-2018, XXX有限公司 FileName: TestServiceImpl Author:   byron Date:     2018/8/8
 * 15:24 Description: History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.config.RunAfterExecutor;
import com.example.demo.dao.StudentDao;
import com.example.demo.pojo.Student;
import com.example.demo.service.StudentService;
import java.util.concurrent.LinkedBlockingQueue;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao,Student> implements StudentService {

  @Override
  public Page<Student> getStudentPage(Page<Student> page,Student student,String orderBy,boolean sort) {
    EntityWrapper<Student> eWrapper = new EntityWrapper<>();
    if(student.getAge() != null){
      eWrapper.eq("age",student.getAge());
    }
    eWrapper.like("name",student.getName());
    eWrapper.orderBy(orderBy,sort);
    page = selectPage(page,eWrapper);
    return page;
  }

  @Override
  public void insertToQueue(String string) {
      try {
//        if (linkedBlockingQueue.size() < 10) {
          RunAfterExecutor.linkedBlockingQueue.put(string);
          System.out.println("队列添加成功");
//        }
      }catch (InterruptedException e){
        throw new IllegalArgumentException("异常");
      }
  }
}


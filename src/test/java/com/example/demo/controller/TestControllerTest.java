package com.example.demo.controller;

import com.example.demo.constant.Constants;
import com.example.demo.service.StudentService;
import javax.servlet.http.Cookie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestControllerTest {

  @Autowired
  private WebApplicationContext wac;
  @Autowired
  public StudentService studentService;

  private Cookie cookie;

  private MockMvc mockMvc;
  @Before
  public void setUp() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    cookie = new Cookie(Constants.LOGIN_COOKIE_SIGN,"");

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void hello2() throws Exception{
    studentService.insertToQueue("哈哈");
    mockMvc.perform(MockMvcRequestBuilders.get("/student/list")
//        .param("pages","2")
        .param("size","2")
//        .param("current","2")
//        .param("age","22")
        .param("name","张")
        .param("orderBy","id")
        .cookie(cookie)
//        .param("sort","desc")
        .accept(MediaType.APPLICATION_JSON))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();

  }
}
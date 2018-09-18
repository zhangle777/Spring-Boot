package com.example.demo.controller;

import static org.junit.Assert.*;

import jdk.net.SocketFlow.Status;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestControllerTest {

  @Autowired
  private WebApplicationContext wac;
  private MockMvc mockMvc;
  @Before
  public void setUp() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void hello() throws Exception{
    mockMvc.perform(MockMvcRequestBuilders.get("/student/list").accept(MediaType.APPLICATION_JSON))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
  }

  @Test
  public void hello2() throws Exception{
    mockMvc.perform(MockMvcRequestBuilders.get("/student/list")
//        .param("pages","2")
        .param("size","2")
//        .param("current","2")
//        .param("age","22")
        .param("name","张")
        .param("orderBy","id")
//        .param("sort","desc")
        .accept(MediaType.APPLICATION_JSON))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();

  }
}
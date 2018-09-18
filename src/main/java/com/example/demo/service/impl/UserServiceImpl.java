package com.example.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author byron
 * @date 2018/8/27 17:53
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {

}

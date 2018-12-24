package com.example.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.dao.UserRoleDao;
import com.example.demo.pojo.UserRole;
import com.example.demo.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * @author byron
 * @date 2018/12/19 11:10
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements
    UserRoleService {

}

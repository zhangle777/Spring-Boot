package com.example.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.dao.RoleDao;
import com.example.demo.pojo.Role;
import com.example.demo.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @author byron
 * @date 2018/12/19 11:08
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

}

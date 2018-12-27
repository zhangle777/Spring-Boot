package com.example.demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author byron
 * @date 2018/8/27 17:53
 */

public interface UserDao extends BaseMapper<User> {

}

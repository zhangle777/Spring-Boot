package com.ahut.serviceImpl;

import com.ahut.entity.User;
import com.ahut.mapper.UserMapper;
import com.ahut.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangle
 * @since 2018-07-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

package com.example.demo.security;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.pojo.Role;
import com.example.demo.pojo.User;
import com.example.demo.pojo.UserRole;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author byron
 * @date 2018/12/19 10:43
 */
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserService userService;
  @Autowired
  private RoleService roleService;
  @Autowired
  private UserRoleService userRoleService;

  private static Logger logger = LoggerFactory.getLogger(FilterInvocationSecurityMetadataSourceImpl.class);

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    logger.info(userName);
    com.example.demo.pojo.User user = userService.selectOne(new EntityWrapper<User>().eq("user_name",userName));
    if(user == null)
      throw new UsernameNotFoundException("没有该用户");
    List<UserRole> userRoles = userRoleService.selectList
        (new EntityWrapper<UserRole>().eq("user_id",user.getId()));
    List<Role> roles = new ArrayList<>();
    userRoles.forEach(item->{
      Role role = roleService.selectById(item.getRoleId());
      roles.add(role);
    });
    return new UserDetailsImpl(user,roles);
//    logger.info("用户的用户名: {}", userName);
//    // TODO 根据用户名，查找到对应的密码，与权限
//
//    // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
//    org.springframework.security.core.userdetails.User user = new User(userName, "123456",
//        AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//    return user;
  }
}

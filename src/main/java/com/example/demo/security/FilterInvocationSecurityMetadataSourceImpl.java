package com.example.demo.security;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.pojo.Resource;
import com.example.demo.pojo.Role;
import com.example.demo.service.ResourceService;
import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author byron
 * @date 2018/12/19 14:10
 */
@Component
public class FilterInvocationSecurityMetadataSourceImpl implements
    FilterInvocationSecurityMetadataSource {

  private static Logger logger = LoggerFactory.getLogger(FilterInvocationSecurityMetadataSourceImpl.class);

  @Autowired
  private ResourceService resourceService;

  @Override
  public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
    String requestUrl = ((FilterInvocation) o).getRequestUrl();
    logger.info("请求的地址为{}",requestUrl);
    if("/login".equals(requestUrl)){
      return null;
    }
    Resource resource = resourceService.selectOne(new EntityWrapper<Resource>().eq("url",requestUrl));
    //如果没有匹配的url则说明大家都可以访问
    if(resource == null){
      return SecurityConfig.createList("ROLE_LOGIN");
    }
    Assert.notNull(resource,"资源为空");
    //根据资源id直接查询出该资源id有哪些权限
    List<Role> roles = resourceService.getRolesByResourceId(resource.getId());
    String[] roleArray = new String[(roles.size())];
    for(int i = 0;i<roles.size();i++){
      roleArray[i] = roles.get(i).getRoleName();
    }
    return SecurityConfig.createList(roleArray);
  }

  @Override
  public Collection<ConfigAttribute> getAllConfigAttributes() {
    return null;
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return false;
  }
}

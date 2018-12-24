package com.example.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.pojo.Resource;
import com.example.demo.dao.ResourceDao;
import com.example.demo.pojo.Role;
import com.example.demo.pojo.RoleResource;
import com.example.demo.service.ResourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.service.RoleResourceService;
import com.example.demo.service.RoleService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangle
 * @since 2018-12-19
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceDao, Resource> implements ResourceService {

  @Autowired
  private RoleResourceService roleResourceService;
  @Autowired
  private RoleService roleService;
  @Override
  public List<Role> getRolesByResourceId(Integer resourceId) {
    List<Role> result = new ArrayList<>();
    List<RoleResource> roleResources = roleResourceService.selectList(new EntityWrapper<RoleResource>().eq("res_id",resourceId));
    roleResources.forEach(item->{
      Role role = roleService.selectById(item.getRoleId());
      result.add(role);
    });
    return result;
  }
}

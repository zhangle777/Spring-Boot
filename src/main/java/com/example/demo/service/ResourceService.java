package com.example.demo.service;

import com.example.demo.pojo.Resource;
import com.baomidou.mybatisplus.service.IService;
import com.example.demo.pojo.Role;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangle
 * @since 2018-12-19
 */
public interface ResourceService extends IService<Resource> {

  List<Role> getRolesByResourceId(Integer resourceId);

}

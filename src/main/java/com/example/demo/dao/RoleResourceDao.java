package com.example.demo.dao;

import com.example.demo.pojo.RoleResource;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangle
 * @since 2018-12-19
 */
@Component
@Mapper
public interface RoleResourceDao extends BaseMapper<RoleResource> {

}

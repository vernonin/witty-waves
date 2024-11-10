package com.witty.mapper;

import com.github.pagehelper.Page;
import com.witty.entity.Role;
import com.witty.entity.dto.RoleDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {
    void create(Role role);

    void update(Role role);

    Role queryById(@Param("id") Integer id);

    void remove(@Param("id") Integer id);

    void removes(@Param("ids") List<Integer> ids);

    Page<Role> queryList(RoleDto roleDto);

}

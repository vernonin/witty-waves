package com.witty.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.witty.common.PageResult;
import com.witty.entity.Role;
import com.witty.entity.dto.RoleDto;
import com.witty.mapper.RoleMapper;
import com.witty.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    /**
     * 新增角色
     * @param role 角色实体
     */
    public void create(Role role) {
        roleMapper.create(role);
    }

    /**
     * 修改角色
     * @param role 角色实体
     */
    public void update(Role role) {
        roleMapper.update(role);
    }

    /**
     * 根据角色id查询角色
     * @param id 角色id
     * @return role
     */
    public Role queryById(Integer id) {
        return roleMapper.queryById(id);
    }

    /**
     * 分页查询角色
     * @param roleDto
     * @return
     */
    public PageResult queryList(RoleDto roleDto) {
        PageHelper.startPage(roleDto.getCurrentPage(), roleDto.getPageSize());
        Page<Role> page = roleMapper.queryList(roleDto);

        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 根据角色id删除角色
     * @param id 角色id
     */
    public void remove(Integer id) {
        roleMapper.remove(id);
    }

    /**
     * 批量删除角色
     * @param ids ids
     */
    public void batchRemove(List<Integer> ids) {
        roleMapper.removes(ids);
    }
}

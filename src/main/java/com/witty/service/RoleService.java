package com.witty.service;

import com.witty.common.PageResult;
import com.witty.entity.Role;
import com.witty.entity.dto.RoleDto;

import java.util.List;

public interface RoleService {
    void create(Role role);

    void update(Role role);

    Role queryById(Integer id);

    PageResult queryList(RoleDto roleDto);

    void remove(Integer id);

    void batchRemove(List<Integer> ids);
}

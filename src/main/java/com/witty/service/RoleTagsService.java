package com.witty.service;

import com.witty.common.PageResult;
import com.witty.entity.RoleTags;
import com.witty.entity.dto.RoleTagsDto;

import java.util.List;

public interface RoleTagsService {
    void create(RoleTags roleTagsDto);

    void update(RoleTags roleTagsDto);

    void remove(Integer id);

    RoleTags queryById(Integer id);

    PageResult queryList(RoleTagsDto roleTagsDto);

    PageResult findAll();

    void batchRemove(List<Integer> ids);
}

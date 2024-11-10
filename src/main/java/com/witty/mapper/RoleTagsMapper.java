package com.witty.mapper;

import com.github.pagehelper.Page;
import com.witty.entity.RoleTags;
import com.witty.entity.dto.RoleTagsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleTagsMapper {
    void create(RoleTags RoleTags);

    void update(RoleTags RoleTags);

    void remove(@Param("tagId") Integer id);

    RoleTags queryById(@Param("tagId") Integer id);

    Page<RoleTags> queryList(RoleTagsDto roleTagsDto);

    List<RoleTags> findAll();

    void removes(@Param("ids") List<Integer> ids);
}

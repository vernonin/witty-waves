package com.witty.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.witty.common.PageResult;
import com.witty.entity.RoleTags;
import com.witty.entity.dto.RoleTagsDto;
import com.witty.mapper.RoleTagsMapper;
import com.witty.service.RoleTagsService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleTagsServiceImpl implements RoleTagsService {
    private final RoleTagsMapper roleTagsMapper;


    RoleTagsServiceImpl(RoleTagsMapper roleTagsMapper) {
        this.roleTagsMapper = roleTagsMapper;
    }

    /**
     * 新增角色标签
     * @param roleTagsDto
     */
    public void create(RoleTags roleTagsDto) {
        roleTagsMapper.create(roleTagsDto);
    }

    /**
     * 修改角色标签
     * @param roleTagsDto
     */
    public void update(RoleTags roleTagsDto) {
        roleTagsMapper.update(roleTagsDto);
    }

    /**
     * 删除角色标签
     * @param id 标签ID
     */
    public void remove(Integer id) {
        roleTagsMapper.remove(id);
    }

    /**
     * 根据标签ID查询角色标签
     * @param id 标签ID
     * @return RoleTags
     */
    public RoleTags queryById(Integer id) {
        return roleTagsMapper.queryById(id);
    }

    /**
     * 分页查询角色标签
     * @param roleTagsDto
     * @return PageResult
     */
    public PageResult queryList(RoleTagsDto roleTagsDto) {
        // 当前页码
        int currentPage = roleTagsDto.getCurrentPage();
        // 每页大小
        int pageSize = roleTagsDto.getPageSize();

        PageHelper.startPage(currentPage, pageSize);
        Page<RoleTags> page = roleTagsMapper.queryList(roleTagsDto);

        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 查询所有角色标签
     * @return PageResult
     */
    @Override
    public PageResult findAll() {
        List<RoleTags> roleTagsList = roleTagsMapper.findAll();
        return new PageResult(roleTagsList.size(), roleTagsList);
    }

    /**
     * 批量删除
     * @param ids ids
     */
    public void batchRemove(List<Integer> ids) {
        roleTagsMapper.removes(ids);
    }
}

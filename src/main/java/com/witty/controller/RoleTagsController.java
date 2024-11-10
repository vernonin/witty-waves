package com.witty.controller;

import com.witty.common.HttpResponses;
import com.witty.common.PageResult;
import com.witty.entity.RoleTags;
import com.witty.entity.dto.RoleTagsDto;
import com.witty.service.RoleTagsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色标签Controller
 */
@RestController
@RequestMapping("/role/tags")
public class RoleTagsController {

    private final RoleTagsService roleTagsService;

    RoleTagsController(RoleTagsService roleTagsService) {
        this.roleTagsService = roleTagsService;
    }

    /**
     * 新增角色标签
     * @param RoleTags
     * @return String
     */
    @PostMapping
    public HttpResponses<String> create(@RequestBody RoleTags RoleTags) {
        roleTagsService.create(RoleTags);
        return HttpResponses.ok("创建成功！");
    }

    /**
     * 修改角色标签
     * @param RoleTags
     * @return String
     */
    @PutMapping
    public HttpResponses<String> update(@RequestBody RoleTags RoleTags) {
        roleTagsService.update(RoleTags);
        return HttpResponses.ok("修改成功！");
    }

    /**
     * 根据标签ID查询标签
     * @param id 标签ID
     * @return RoleTags
     */
    @GetMapping("/{id}")
    public HttpResponses<RoleTags> queryById(@PathVariable("id") Integer id) {
        return HttpResponses.ok(roleTagsService.queryById(id));
    }

    /**
     * 分页查询角色标签
     * @param roleTagsDto roleTagsDto
     * @return List<RoleTags>
     */
    @GetMapping("/list")
    public HttpResponses<PageResult> queryList(RoleTagsDto roleTagsDto) {
        return HttpResponses.ok(roleTagsService.queryList(roleTagsDto));
    }

    /**
     * 查询所有角色标签
     * @return PageResult
     */
    @GetMapping("/all")
    public HttpResponses<PageResult> queryAll() {
        return HttpResponses.ok(roleTagsService.findAll());
    }

    /**
     * 根据ID删除角色标签
     * @param id 标签id
     * @return String
     */
    @DeleteMapping("/{id}")
    public HttpResponses<String> remove(@PathVariable("id") Integer id) {
        roleTagsService.remove(id);
        return HttpResponses.ok("删除成功！");
    }

    /**
     * 批量删除
     * @param ids ids
     * @return String
     */
    @DeleteMapping("/batch")
    public HttpResponses<String> removes(@RequestParam("ids") List<Integer> ids) {
        roleTagsService.batchRemove(ids);
        return HttpResponses.ok("删除成功！");
    }
}

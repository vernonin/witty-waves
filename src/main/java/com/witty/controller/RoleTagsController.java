package com.witty.controller;

import com.witty.common.HttpResponses;
import com.witty.common.PageResult;
import com.witty.entity.RoleTags;
import com.witty.entity.dto.RoleTagsDto;
import com.witty.service.RoleTagsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 角色标签Controller
 */
@Api(value = "角色标签", tags = "角色标签")
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
    @ApiOperation("新增角色标签")
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
    @ApiOperation("修改角色标签")
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
    @ApiOperation("根据标签ID查询标签")
    @GetMapping("/{id}")
    public HttpResponses<RoleTags> queryById(@PathVariable("id") Integer id) {
        return HttpResponses.ok(roleTagsService.queryById(id));
    }

    /**
     * 分页查询角色标签
     * @param roleTagsDto roleTagsDto
     * @return List<RoleTags>
     */
    @ApiOperation("分页查询角色标签")
    @GetMapping("/list")
    public HttpResponses<PageResult> queryList(RoleTagsDto roleTagsDto) {
        return HttpResponses.ok(roleTagsService.queryList(roleTagsDto));
    }

    /**
     * 查询所有角色标签
     * @return PageResult
     */
    @ApiOperation("查询所有角色标签")
    @GetMapping("/all")
    public HttpResponses<PageResult> queryAll() {
        return HttpResponses.ok(roleTagsService.findAll());
    }

    /**
     * 根据ID删除角色标签
     * @param id 标签id
     * @return String
     */
    @ApiOperation("根据ID删除角色标签")
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
    @ApiOperation("批量删除角色标签")
    @DeleteMapping("/batch")
    public HttpResponses<String> removes(@RequestParam("ids") List<Integer> ids) {
        roleTagsService.batchRemove(ids);
        return HttpResponses.ok("删除成功！");
    }
}

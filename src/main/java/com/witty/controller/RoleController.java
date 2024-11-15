package com.witty.controller;

import com.witty.common.HttpResponses;
import com.witty.common.PageResult;
import com.witty.common.constant.OperateMsg;
import com.witty.entity.Role;
import com.witty.entity.dto.RoleDto;
import com.witty.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色(嗓音)Controller
 */
@Api(value = "角色(嗓音)", tags = "角色(嗓音)")
@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * 新增角色(嗓音)
     * @param role 角色实体
     * @return String
     */
    @ApiOperation("新增角色")
    @PostMapping
    public HttpResponses<String> create(@RequestBody Role role) {
        roleService.create(role);
        return HttpResponses.ok(OperateMsg.CREATE_SUCCESS);
    }

    /**
     * 修改角色(嗓音)
     * @param role 角色实体
     * @return String
     */
    @ApiOperation("修改角色")
    @PutMapping
    public HttpResponses<String> update(@RequestBody Role role) {
        roleService.update(role);
        return HttpResponses.ok(OperateMsg.UPDATE_SUCCESS);
    }

    /**
     * 根据角色Id查询角色
     * @param id 角色id
     * @return role
     */
    @ApiOperation("根据角色Id查询角色")
    @GetMapping("/{id}")
    public HttpResponses<Role> queryById(@PathVariable("id") Integer id) {
        return HttpResponses.ok(roleService.queryById(id));
    }

    /**
     * 分页查询角色
     * @param roleDto 角色实体
     * @return PageResult
     */
    @ApiOperation("分页查询角色")
    @GetMapping("/list")
    public HttpResponses<PageResult> queryList(RoleDto roleDto) {
        return HttpResponses.ok(roleService.queryList(roleDto));
    }

    /**
     * 根据角色Id删除角色
     * @param id 角色id
     * @return String
     */
    @ApiOperation("根据角色Id删除角色")
    @DeleteMapping("/{id}")
    public HttpResponses<String> remove(@PathVariable("id") Integer id) {
        roleService.remove(id);
        return HttpResponses.ok(OperateMsg.REMOVE_SUCCESS);
    }

    /**
     * 批量删除角色
     * @param ids ids
     * @return String
     */
    @ApiOperation("批量删除角色")
    @DeleteMapping("/batch")
    public HttpResponses<String> removes(@RequestParam("ids") List<Integer> ids) {
        roleService.batchRemove(ids);
        return HttpResponses.ok(OperateMsg.REMOVE_SUCCESS);
    }
}

package com.witty.controller;

import com.witty.common.HttpResponses;
import com.witty.common.PageResult;
import com.witty.common.constant.OperateMsg;
import com.witty.entity.User;
import com.witty.entity.dto.UserDto;
import com.witty.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户Controller
 */
@Api(value = "用户", tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ApiOperation("新增用户")
    @PostMapping
    public HttpResponses create(@RequestBody User user) {
        userService.create(user);
        return HttpResponses.ok(OperateMsg.CREATE_SUCCESS);
    }

    @ApiOperation("修改用户")
    @PutMapping
    public HttpResponses update(@RequestBody User user) {
        userService.update(user);
        return HttpResponses.ok(OperateMsg.UPDATE_SUCCESS);
    }

    @ApiOperation("根据用户Id查询用户")
    @GetMapping("/{id}")
    public HttpResponses<User> queryById(@PathVariable Integer id) {
        return HttpResponses.ok(userService.queryById(id));
    }

    @ApiOperation("分页查询用户")
    @GetMapping("/list")
    public HttpResponses<PageResult> queryList(UserDto userDto) {
        return HttpResponses.ok(userService.queryList(userDto));
    }

    @ApiOperation("根据用户Id删除用户")
    @DeleteMapping("/{id}")
    public HttpResponses remove(@PathVariable Integer id) {
        userService.remove(id);
        return HttpResponses.ok(OperateMsg.REMOVE_SUCCESS);
    }

    @ApiOperation("批量删除用户")
    @DeleteMapping("/batch")
    public HttpResponses removes(@RequestParam("ids") List<Integer> ids) {
        userService.removes(ids);
        return HttpResponses.ok(OperateMsg.REMOVE_SUCCESS);
    }
}

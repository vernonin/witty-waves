package com.witty.service;

import com.witty.common.PageResult;
import com.witty.entity.User;
import com.witty.entity.dto.UserDto;

import java.util.List;

public interface UserService {
    void create(User user);

    void register(User user);

    void update(User user);

    User queryById(Integer id);

    PageResult queryList(UserDto userDto);

    void remove(Integer id);

    void removes(List<Integer> ids);

    boolean checkUsernameUnique(User user);
}

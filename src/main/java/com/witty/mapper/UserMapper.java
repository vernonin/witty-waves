package com.witty.mapper;

import com.github.pagehelper.Page;
import com.witty.entity.User;
import com.witty.entity.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    void create(User user);

    void update(User user);

    User queryById(@Param("id") Integer id);

    Page<User> queryList(UserDto userDto);

    void remove(@Param("id") Integer id);

    void removes(@Param("ids") List<Integer> ids);
}

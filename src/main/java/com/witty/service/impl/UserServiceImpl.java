package com.witty.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.witty.common.PageResult;
import com.witty.entity.User;
import com.witty.entity.dto.UserDto;
import com.witty.execption.BusinessException;
import com.witty.mapper.UserMapper;
import com.witty.service.UserService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 新增用户
     * @param user
     */
    public void create(User user) {
        // 默认金额：500
        user.setCoins(user.getCoins() != null ? user.getCoins() : new BigDecimal("500"));

        userMapper.create(user);
    }

    /**
     * 更新用户信息
     * @param user
     */
    public void update(User user) {

        if (user.getId() == null) {
            throw  new BusinessException("请传入用户Id");
        }

        userMapper.update(user);
    }

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    public User queryById(Integer id) {
        User user = userMapper.queryById(id);
        if (user != null) {
            user.setPassword("******");
        }
        return user;
    }

    /**
     * 分页查询用户
     * @param userDto
     * @return
     */
    public PageResult queryList(UserDto userDto) {
        PageHelper.startPage(userDto.getCurrentPage(), userDto.getPageSize());
        Page<User> page = userMapper.queryList(userDto);

        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 根据用户id删除用户
     * @param id
     */
    public void remove(Integer id) {
        if (id != null && id.equals(1)) {
            throw new BusinessException("管理员账号不可删除！");
        }
        userMapper.remove(id);
    }

    /**
     * 批量删除用户
     * @param ids
     */
        public void removes(List<Integer> ids) {
        if (ids != null && ids.contains(1)) {
            throw new BusinessException("包含管理员账号，不可删除！");
        }
        userMapper.removes(ids);
    }
}

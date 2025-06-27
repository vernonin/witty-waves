package com.witty.controller;

import com.witty.common.HttpResponses;
import com.witty.common.constant.OperateMsg;
import com.witty.entity.User;
import com.witty.entity.dto.UserLoginDto;
import com.witty.execption.BusinessException;
import com.witty.service.UserService;
import com.witty.utils.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@Api(value = "权限认证", tags = "权限认证")
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthController(JwtTokenUtil jwtTokenUtil, AuthenticationManager authenticationManager, UserService userService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @ApiOperation("用户名密码登录")
    @PostMapping("/login")
    public HttpResponses<String> getAuth(@RequestBody UserLoginDto userLogin) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtTokenUtil.generateToken(new HashMap<>(), userLogin.getUsername());

            return HttpResponses.ok("ok", token);
        } catch (BadCredentialsException e) {
          throw new BusinessException(OperateMsg.PASSWORD_ERROR);
        }
    }

    @ApiOperation("注册账号")
    @PostMapping("/register")
    public HttpResponses<String> register(@RequestBody User user) {
        String msg = "";

        if (!userService.checkUsernameUnique(user)) {
            msg = user.getUsername() + "已存在，请登录或注册新用户!";
            throw new BusinessException(msg);
        }

        userService.register(user);
        msg = "注册成功，请登录";
        return HttpResponses.ok(msg);
    }
}

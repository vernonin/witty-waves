package com.witty.execption;

import cn.hutool.json.JSONUtil;
import com.witty.common.HttpResponses;
import com.witty.common.constant.OperateMsg;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 认证失败处理类 返回未授权
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(JSONUtil.toJsonStr(HttpResponses.error(OperateMsg.UNAUTHORIZED)));
    }
}

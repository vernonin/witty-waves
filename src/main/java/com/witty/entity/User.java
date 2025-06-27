package com.witty.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;

    /** 用户名 */
    private String username;

    /** 姓名 */
    private String name;

    /** 密码 */
    private String password;

    /** 邮箱 */
    private String email;

    /** 手机号 */
    private String phone;

    /** 性别 */
    private Integer gender;

    /** 头像 */
    private String avatar;

    /** 状态 */
    private Integer status;

    /** 是否VIP */
    private Integer isVip;

    /** 金额 */
    private BigDecimal coins;

    /** 角色 */
    private Set<GrantedAuthority> roles;

    /** 创建时间 */
    private LocalDateTime createTime;
}

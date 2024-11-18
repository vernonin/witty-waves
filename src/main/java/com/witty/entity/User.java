package com.witty.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    Integer id;

    /** 用户名 */
    String username;

    /** 姓名 */
    String name;

    /** 密码 */
    String password;

    /** 邮箱 */
    String email;

    /** 手机号 */
    String phone;

    /** 性别 */
    Integer gender;

    /** 头像 */
    String avatar;

    /** 状态 */
    Integer status;

    /** 是否VIP */
    Integer isVip;

    /** 金额 */
    BigDecimal coins;

    /** 创建时间 */
    LocalDateTime createTime;
}

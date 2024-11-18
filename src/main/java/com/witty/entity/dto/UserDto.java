package com.witty.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto extends PageQueryDto {
    /** 用户名 */
    String username;

    /** 姓名 */
    String name;

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
}

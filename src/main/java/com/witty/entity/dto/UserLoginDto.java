package com.witty.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLoginDto {
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;
}

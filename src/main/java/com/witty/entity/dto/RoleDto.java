package com.witty.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleDto extends PageQueryDto {
    // 名称
    private String name;

    // 文本内容
    private String content;

    // 描述
    private String description;

    // 对应的标签Id
    private Integer tagId;
}

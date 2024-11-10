package com.witty.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleTagsDto extends PageQueryDto {
    // 名称
    private String name;

    // 别名（中文名）
    private String alias;
}

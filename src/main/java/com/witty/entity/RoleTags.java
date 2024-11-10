package com.witty.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 声音角色标签实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleTags {
    // id
    private Integer id;

    // 名称
    private String name;

    // 别名（中文名）
    private String alias;

    // 创建时间
    private LocalDateTime createTime;

    // 修改时间
    private LocalDateTime updateTime;
}

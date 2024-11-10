package com.witty.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 角色(嗓音)实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {
    // id
    private Integer id;

    // 角色名称
    private String name;

    // 头像
    private String avatar;

    // 声音地址
    private String voiceUrl;

    // 声音Id
    private String voiceId;

    // 文本内容
    private String content;

    // 描述
    private String description;

    // 对应的标签Id
    private Integer tagId;

    // 创建人
    private String createBy;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;
}

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
public class Generate {
    // id
    private Integer id;

    // 文本
    private String text;

    // 时长
    private BigDecimal duration;

    // 声音地址
    private String audioSrc;

    // 用户id
    private Integer userId;

    // 创建人
    private String createBy;

    // 创建时间
    private LocalDateTime createTime;
}

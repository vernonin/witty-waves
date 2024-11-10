package com.witty.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GenerateDto extends PageQueryDto {
    // 文本
    private String text;

    // 用户id
    private Integer userId;
}

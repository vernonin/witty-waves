package com.witty.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageQueryDto {
    // 当前页码
    private int currentPage;

    // 每页显示记录数
    private int pageSize;
}

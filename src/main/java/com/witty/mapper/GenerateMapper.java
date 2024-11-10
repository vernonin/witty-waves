package com.witty.mapper;

import com.github.pagehelper.Page;
import com.witty.entity.Generate;
import com.witty.entity.dto.GenerateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GenerateMapper {
    void remove(@Param("id") Integer id);

    Page<Generate> queryList(GenerateDto generateDto);

    void create(Generate generate);
}

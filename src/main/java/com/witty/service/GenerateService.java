package com.witty.service;

import com.witty.common.PageResult;
import com.witty.entity.Generate;
import com.witty.entity.SoundDto;
import com.witty.entity.dto.GenerateDto;

public interface GenerateService {
    void remove(Integer id);


    PageResult queryList(GenerateDto generateDto);

    Generate create(SoundDto soundDto);
}

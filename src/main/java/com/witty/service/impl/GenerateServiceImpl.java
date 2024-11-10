package com.witty.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.witty.common.PageResult;
import com.witty.entity.Generate;
import com.witty.entity.SoundDto;
import com.witty.entity.dto.GenerateDto;
import com.witty.mapper.GenerateMapper;
import com.witty.service.GenerateService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class GenerateServiceImpl implements GenerateService {
    private final GenerateMapper generateMapper;

    public GenerateServiceImpl(GenerateMapper generateMapper) {
        this.generateMapper = generateMapper;
    }

    /**
     * 根据id删除
     * @param id id
     */
    public void remove(Integer id) {
        generateMapper.remove(id);
    }

    /**
     * 分页查询
     * @param generateDto dto
     * @return
     */
    public PageResult queryList(GenerateDto generateDto) {
        PageHelper.startPage(generateDto.getCurrentPage(), generateDto.getPageSize());
        Page<Generate> page = generateMapper.queryList(generateDto);

        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 生成配音
     * @param soundDto
     * @return
     */
    public Generate create(SoundDto soundDto) {
        String result = HttpRequest.post("https://v1.reecho.cn/api/tts/simple-generate")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer token")
                .body(JSONUtil.toJsonStr(soundDto))
                .execute().body();

        System.out.println(JSONUtil.toJsonStr(soundDto));
        System.out.println(result);

        Generate generate = new Generate(null, soundDto.getText(), new BigDecimal("2"), "", 1, "admin", LocalDateTime.now());
        generateMapper.create(generate);
        return generate;
    }

}

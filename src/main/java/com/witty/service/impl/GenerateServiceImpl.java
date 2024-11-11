package com.witty.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.witty.common.AppProperties;
import com.witty.common.PageResult;
import com.witty.entity.Generate;
import com.witty.entity.SoundDto;
import com.witty.entity.dto.GenerateDto;
import com.witty.entity.dto.ReechoResponseDto;
import com.witty.execption.BusinessException;
import com.witty.mapper.GenerateMapper;
import com.witty.service.GenerateService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class GenerateServiceImpl implements GenerateService {
    private final GenerateMapper generateMapper;
    private final AppProperties appProperties;

    public GenerateServiceImpl(GenerateMapper generateMapper, AppProperties appProperties) {
        this.generateMapper = generateMapper;
        this.appProperties = appProperties;
    }

    /**
     * 根据id删除
     *
     * @param id id
     */
    public void remove(Integer id) {
        generateMapper.remove(id);
    }

    /**
     * 分页查询
     *
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
     *
     * @param soundDto
     * @return
     */
    public Generate create(SoundDto soundDto) {
        try {
            AppProperties.Reecho reecho = appProperties.getReecho();

            String result = HttpRequest.post(reecho.getGenerateUrl())
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + reecho.getToken())
                    .body(JSONUtil.toJsonStr(soundDto))
                    .execute().body();


            ObjectMapper objectMapper = new ObjectMapper();
            ReechoResponseDto reechoResponseDto = objectMapper.readValue(result, ReechoResponseDto.class);
            handleResponse(reechoResponseDto);

            Generate generate = new Generate(null, soundDto.getText(), new BigDecimal("2"), "", 1, "admin", LocalDateTime.now());
            generateMapper.create(generate);
            return generate;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    private void handleResponse(ReechoResponseDto reechoResponseDto) {
        if (reechoResponseDto.getStatus() != 200 && reechoResponseDto.getStatus() != 201) {
            throw new BusinessException(reechoResponseDto.getMessage());
        }
    }
}

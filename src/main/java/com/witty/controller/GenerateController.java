package com.witty.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.witty.common.HttpResponses;
import com.witty.common.PageResult;
import com.witty.common.constant.OperateMsg;
import com.witty.entity.Generate;
import com.witty.entity.SoundDto;
import com.witty.entity.dto.GenerateDto;
import com.witty.entity.dto.PageQueryDto;
import com.witty.service.GenerateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.val;
import org.springframework.web.bind.annotation.*;

/**
 * 声音生成
 */
@Api(value = "声音", tags = "声音")
@RestController
@RequestMapping("/generate")
public class GenerateController {
    private final GenerateService generateService;

    public GenerateController(GenerateService generateService) {
        this.generateService = generateService;
    }

    /**
     * 根据声音角色，文本内容生成声音
     * @param soundDto
     * @return
     */
    @ApiOperation("生成声音")
    @PostMapping("/sound")
    public HttpResponses<Generate> getSound(@RequestBody SoundDto soundDto) {
        Generate generate = generateService.create(soundDto);

        return HttpResponses.ok(generate);
    };

    /**
     * 历史生产声音
     * @param text 文本
     * @return PageResult
     */
    @ApiOperation("历史生产声音")
    @GetMapping("/self")
    public HttpResponses<PageResult> queryListBySelf(String text) {
        Integer userId = 1;
        GenerateDto generateDto = new GenerateDto();

        generateDto.setUserId(userId);
        generateDto.setText(text);
        PageResult result = generateService.queryList(generateDto);
        return HttpResponses.ok(result);
    };

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @ApiOperation("根据id删除声音")
    @DeleteMapping("/{id}")
    public HttpResponses remove(@PathVariable Integer id) {
        generateService.remove(id);
        return HttpResponses.ok(OperateMsg.REMOVE_SUCCESS);
    };
}

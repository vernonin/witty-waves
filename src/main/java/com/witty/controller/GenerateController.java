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
import org.springframework.web.bind.annotation.*;

/**
 * 声音生成
 */
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
    @PostMapping("/sound")
    public HttpResponses<Generate> getSound(@RequestBody SoundDto soundDto) {
        Generate generate =  generateService.create(soundDto);

        return HttpResponses.ok(generate);
    };

    @GetMapping("/test")
    public HttpResponses getTest() {
      return HttpResponses.error("报错了");
    };

    @GetMapping("/self")
    public HttpResponses<PageResult> queryListBySelf(GenerateDto generateDto) {
        Integer userId = 1;

        generateDto.setUserId(userId);
        PageResult result = generateService.queryList(generateDto);
        return HttpResponses.ok(result);
    };

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public HttpResponses remove(@PathVariable Integer id) {
        generateService.remove(id);
        return HttpResponses.ok(OperateMsg.REMOVE_SUCCESS);
    };
}

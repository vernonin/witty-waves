package com.witty.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色
 */
@RestController
@RequestMapping("/voice")
public class VoiceController {

    /**
     * 获取当前用户的语音角色列表
     * @return string
     */
    @GetMapping("/self")
    public String getVoiceListBySelf() {
        String result = HttpRequest.get("https://v1.reecho.cn/api/tts/voice")
                                .header("Authorization", "Bearer xxxxxxx")
                                .execute().body();

        System.out.println(result);
        return result;
    }
}

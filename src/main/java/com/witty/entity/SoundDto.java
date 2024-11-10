package com.witty.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SoundDto {
    /** 语音角色 ID */
    private String voiceId;

    /** 要生成的文本内容 */
    private String text;
}

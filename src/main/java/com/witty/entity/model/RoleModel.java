package com.witty.entity.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleModel {
    @ExcelProperty("name")
    private String name;

    @ExcelProperty("avatar")
    private String avatar;

    @ExcelProperty("voice_url")
    private String voiceUrl;

    @ExcelProperty("voice_id")
    private String voiceId;

    @ExcelProperty("content")
    private String content;

    @ExcelProperty("description")
    private String description;

    @ExcelProperty("tag_id")
    private Integer tagId;


    @Override
    public String toString() {
        return "RoleModel{" +
                "name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", voiceUrl='" + voiceUrl + '\'' +
                ", voiceId='" + voiceId + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", tagId='" + tagId + '\'' +
                '}';
    }
}

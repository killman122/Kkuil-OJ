package com.kkuil.kkuilojquestionservice.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Kkuil
 * @Date 2023/08/11 11:45
 * @Description 添加问题数据传输对象
 */
@Data
@Accessors(chain = true)
public class AddQuestionDTO {

    /**
     * 题目标题
     */
    private String title;

    /**
     * 题目描述
     */
    private String description;

    /**
     * 难度等级 0-入门 1-简单 2-中等 3-偏难 4-困难 5-地狱
     */
    private Integer difficulty;

    /**
     * 题目要求
     */
    private String required;
}

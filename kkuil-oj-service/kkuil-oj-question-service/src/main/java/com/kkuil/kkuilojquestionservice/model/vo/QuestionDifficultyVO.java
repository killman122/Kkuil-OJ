package com.kkuil.kkuilojquestionservice.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Kkuil
 * @Date 2023/8/12 0:43
 * @Description 题目难度列表展示字段类
 */
@Data
@Accessors(chain = true)
public class QuestionDifficultyVO {
    /**
     * 题目难度编号
     */
    private Long value;

    /**
     * 题目难度名称
     */
    private String name;
}

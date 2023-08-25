package com.kkuil.kkuilojjudgeservice.judge.model.dto;

import lombok.Data;

/**
 * @Author Kkuil
 * @Date 2023/8/14 0:06
 * @Description 代码提交DTO
 */
@Data
public class QuestionJudgeDTO {
    /**
     * 问题ID
     */
    private String questionId;

    /**
     * 代码
     */
    private String code;

    /**
     * 编程语言语言
     */
    private String lang;
}

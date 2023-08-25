package com.kkuil.kkuilojjudgeservice.judge.model.vo;

import lombok.Data;

/**
 * @Author Kkuil
 * @Date 2023/8/14 0:22
 * @Description 代码提交返回实体
 */
@Data
public class QuestionJudgeVO {
    /**
     * 代码执行结果 0-通过 1-未通过
     */
    private String execResult;

    /**
     * 代码执行状态
     */
    private String execStatus;

    /**
     * 代码执行信息
     */
    private String execMessage;

    /**
     * 代码执行时间
     */
    private Long execTime;

    /**
     * 代码消耗内存
     */
    private Long execMemory;
}

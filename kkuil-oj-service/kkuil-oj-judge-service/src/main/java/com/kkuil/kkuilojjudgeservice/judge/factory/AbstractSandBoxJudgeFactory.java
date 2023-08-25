package com.kkuil.kkuilojjudgeservice.judge.factory;

import com.kkuil.kkuilojjudgeservice.judge.model.dto.QuestionJudgeDTO;

/**
 * @Author Kkuil
 * @Date 2023/8/14 0:34
 * @Description 抽象判题工厂
 */
public abstract class AbstractSandBoxJudgeFactory {

    /**
     * 运行代码逻辑
     * @param questionJudgeDTO 代码提交信息
     * @return 执行结果信息
     */
    public abstract Object run(QuestionJudgeDTO questionJudgeDTO);
}

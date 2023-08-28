package com.kkuil.kkuilojjudgeservice.judge.factory.factories;

import com.kkuil.kkuilojjudgeservice.judge.factory.AbstractSandBoxJudgeFactory;
import com.kkuil.kkuilojjudgeservice.judge.model.dto.QuestionJudgeDTO;

/**
 * @Author Kkuil
 * @Date 2023/8/14 0:48
 * @Description 正确代码沙箱工厂
 */
public class SimpleSandBoxJudgeFactory extends AbstractSandBoxJudgeFactory {
    /**
     * 运行代码逻辑
     *
     * @param questionJudgeDTO 代码提交信息
     * @return 执行结果信息
     */
    @Override
    public Object run(QuestionJudgeDTO questionJudgeDTO) {
        return null;
    }
}

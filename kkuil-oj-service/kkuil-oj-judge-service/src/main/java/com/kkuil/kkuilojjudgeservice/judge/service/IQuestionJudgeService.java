package com.kkuil.kkuilojjudgeservice.judge.service;

import com.kkuil.common.utils.ResultUtil;
import com.kkuil.kkuilojjudgeservice.judge.model.dto.QuestionJudgeDTO;
import com.kkuil.kkuilojjudgeservice.judge.model.vo.QuestionJudgeVO;

/**
 * @Author Kkuil
 * @Date 2023/8/14 0:52
 * @Description 判题服务接口
 */
public interface IQuestionJudgeService {
    /**
     * 执行判题
     *
     * @param questionJudgeDTO 代码提交信息
     * @return 执行结果信息
     */
    ResultUtil<QuestionJudgeVO> doJudge(QuestionJudgeDTO questionJudgeDTO);
}

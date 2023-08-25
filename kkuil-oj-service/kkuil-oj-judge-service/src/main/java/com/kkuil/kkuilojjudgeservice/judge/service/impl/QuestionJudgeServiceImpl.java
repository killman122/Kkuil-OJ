package com.kkuil.kkuilojjudgeservice.judge.service.impl;

import com.kkuil.common.enums.ExecResultEnum;
import com.kkuil.common.utils.ResultUtil;
import com.kkuil.kkuilojjudgeservice.judge.factory.AbstractSandBoxJudgeFactory;
import com.kkuil.kkuilojjudgeservice.judge.model.dto.QuestionJudgeDTO;
import com.kkuil.kkuilojjudgeservice.judge.model.vo.QuestionJudgeVO;
import com.kkuil.kkuilojjudgeservice.judge.service.IQuestionJudgeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author Kkuil
 * @Date 2023/8/14 0:51
 * @Description 判题服务类
 */
@Service
public class QuestionJudgeServiceImpl implements IQuestionJudgeService {

    @Resource
    private Map<String, AbstractSandBoxJudgeFactory> sandBoxJudgeFactoryMap;

    /**
     * 执行判题
     *
     * @param questionJudgeDTO 代码提交信息
     * @return 执行结果信息
     */
    @Override
    public ResultUtil<QuestionJudgeVO> doJudge(QuestionJudgeDTO questionJudgeDTO) {
        System.out.println("questionJudgeDTO = " + questionJudgeDTO);
        System.out.println("sandBoxJudgeFactoryMap.toString() = " + sandBoxJudgeFactoryMap.toString());
        QuestionJudgeVO questionJudgeVO = new QuestionJudgeVO();
        questionJudgeVO.setExecResult(ExecResultEnum.PASS.getValue());
        questionJudgeVO.setExecStatus("执行结束");
        questionJudgeVO.setExecMessage("解答正确");
        questionJudgeVO.setExecTime(2000L);
        questionJudgeVO.setExecMemory(2000L);
        return ResultUtil.success(questionJudgeVO);
    }
}

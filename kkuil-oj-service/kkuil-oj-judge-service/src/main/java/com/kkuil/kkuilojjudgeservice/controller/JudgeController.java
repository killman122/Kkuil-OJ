package com.kkuil.kkuilojjudgeservice.controller;

import com.kkuil.common.utils.ResultUtil;
import com.kkuil.kkuilojjudgeservice.judge.model.dto.QuestionJudgeDTO;
import com.kkuil.kkuilojjudgeservice.judge.model.vo.QuestionJudgeVO;
import com.kkuil.kkuilojjudgeservice.judge.service.IQuestionJudgeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Kkuil
 * @Date 2023/07/29 20:00
 * @Description 用户控制器
 */
@Slf4j
@RestController
public class JudgeController {

    @Resource
    private IQuestionJudgeService questionJudgeService;

    /**
     * @param questionJudgeDTO 判题实体
     * @return 判题结果
     * @description 判题接口
     */
    @PostMapping("/run")
    @Operation(summary = "判题", description = "判题")
    @Parameter(name = "questionJudgeDTO", required = true)
    public ResultUtil<QuestionJudgeVO> doJudge(@RequestBody QuestionJudgeDTO questionJudgeDTO) {
        return questionJudgeService.doJudge(questionJudgeDTO);
    }
}

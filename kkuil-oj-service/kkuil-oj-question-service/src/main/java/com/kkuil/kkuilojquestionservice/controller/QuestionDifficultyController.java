package com.kkuil.kkuilojquestionservice.controller;

import com.kkuil.common.enums.QuestionDifficultyEnum;
import com.kkuil.common.utils.ResultUtil;
import com.kkuil.kkuilojquestionservice.model.vo.QuestionDifficultyVO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Kkuil
 * @Date 2023/8/12 0:41
 * @Description 题目难度控制类
 */
@Slf4j
@RestController
@RequestMapping("/difficulty")
public class QuestionDifficultyController {

    /**
     * @return 题目难度列表
     */
    @GetMapping("/list")
    @Operation(summary = "获取题目难度列表", description = "获取题目难度列表")
    public ResultUtil<List<QuestionDifficultyVO>> getDifficulty() {
        ArrayList<QuestionDifficultyVO> questionDifficultyVOS = new ArrayList<>();
        QuestionDifficultyEnum[] values = QuestionDifficultyEnum.values();
        for (QuestionDifficultyEnum value : values) {
            QuestionDifficultyVO questionDifficultyVO = new QuestionDifficultyVO();
            questionDifficultyVO
                    .setValue(value.getValue())
                    .setName(value.getName());
            questionDifficultyVOS.add(questionDifficultyVO);
        }
        return ResultUtil.success("获取成功", questionDifficultyVOS);
    }
}

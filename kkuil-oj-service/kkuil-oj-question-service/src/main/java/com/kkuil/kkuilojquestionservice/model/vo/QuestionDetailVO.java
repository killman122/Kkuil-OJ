package com.kkuil.kkuilojquestionservice.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @Author Kkuil
 * @Date 2023/08/09 18:00
 * @Description 题目详情信息
 */
@Data
@Accessors(chain = true)
public class QuestionDetailVO implements Serializable {
    /**
     * 题目编号
     */
    private Long id;

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

    /**
     * 最后一次修改时间
     */
    private Date modifiedTime;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}

package com.kkuil.kkuilojcodeservice.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author Kkuil
 * @Date 2023/08/11 11:30
 * @Description 提交记录
 * @TableName tb_commit_record
 */
@TableName(value = "tb_commit_record")
@Data
public class TbCommitRecord implements Serializable {
    /**
     * 提交记录编号
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 题目编号
     */
    @TableField(value = "question_id")
    private Long questionId;

    /**
     * 提交代码的用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 所用的编程语言
     */
    @TableField(value = "lang")
    private String lang;

    /**
     * 提交的代码
     */
    @TableField(value = "code")
    private String code;

    /**
     * 代码执行结果(1-失败 0-成功)
     */
    @TableField(value = "exec_result")
    private Integer execResult;

    /**
     * 代码执行反馈消息
     */
    @TableField(value = "exec_message")
    private String execMessage;

    /**
     * 代码执行时间单位ms
     */
    @TableField(value = "exec_time")
    private Date execTime;

    /**
     * 代码执行所消耗的内存单位KB
     */
    @TableField(value = "exec_memory")
    private Integer execMemory;

    /**
     * 是否逻辑删除(0：未删除 1：已删除)
     */
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @TableField(value = "created_time")
    private Date createdTime;

    /**
     * 最后一次修改时间
     */
    @TableField(value = "modified_time")
    private Date modifiedTime;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}

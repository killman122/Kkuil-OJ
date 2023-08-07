package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tb_question
 */
@TableName(value ="tb_question")
@Data
public class TbQuestion implements Serializable {
    /**
     * 题目编号
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 题目标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 题目描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 难度等级 0-入门 1-简单 2-中等 3-偏难 4-困难 5-地狱
     */
    @TableField(value = "rank")
    private Integer rank;

    /**
     * 是否逻辑删除(0：未删除 1：已删除)
     */
    @TableField(value = "is_deleted")
    private Integer is_deleted;

    /**
     * 创建时间
     */
    @TableField(value = "created_time")
    private Date created_time;

    /**
     * 最后一次修改时间
     */
    @TableField(value = "modified_time")
    private Date modified_time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
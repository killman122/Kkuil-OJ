package com.kkuil.kkuilojuserservice.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NonNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @TableName tb_user
 */
@TableName(value = "tb_user")
@Data
public class TbUser implements Serializable {
    /**
     * 用户id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @NonNull
    private String username;

    /**
     * 用户密码
     */
    @TableField(value = "password")
    @NonNull
    private String password;

    /**
     * 用户权限
     */
    @TableField(value = "role")
    @NonNull
    private String role;

    /**
     * 是否逻辑删除(0：未删除 1：已删除)
     */
    @TableField(value = "is_deleted")
    @NonNull
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @TableField(value = "created_time")
    @NonNull
    private Date createdTime;

    /**
     * 最后一次修改时间
     */
    @TableField(value = "modified_time")
    @NonNull
    private Date modifiedTime;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
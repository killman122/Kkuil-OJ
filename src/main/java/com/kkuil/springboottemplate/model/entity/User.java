package com.kkuil.springboottemplate.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author kkuil
 * @Date 2023/07/29 20:00
 * @Description 用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 用户id
     */
    @TableId
    private Integer id;
    /**
     * 用户名
     */
    @TableField("name")
    private String name;
    /**
     * 密码
     */
    @TableField("password")
    private String password;
}

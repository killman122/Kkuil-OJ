package com.kkuil.kkuilojuserservice.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Kkuil
 * @Date 2023/08/06 16:30
 * @Description 用户授权数据传输对象
 */
@Data
@Accessors(chain = true)
public class UserAuthVO {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户角色
     */
    private String role;

    /**
     * 用户token
     */
    private String token;
}

package com.kkuil.kkuilojuserservice.model.dto;

import lombok.Data;

/**
 * @Author Kkuil
 * @Date 2023/08/05 12:00
 * @Description 用户登录DTO
 */
@Data
public class UserLoginDTO {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}

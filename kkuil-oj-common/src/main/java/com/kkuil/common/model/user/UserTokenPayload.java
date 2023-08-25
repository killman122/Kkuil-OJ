package com.kkuil.common.model.user;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author 小K
 * @Date 2023/08/05 13:00
 * @Description 存储在Token中的用户信息
 */
@Data
@Accessors(chain = true)
public class UserTokenPayload {
    /**
     * 用户ID
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
}

package com.kkuil.kkuilojuserservice.constant;

/**
 * @Author 小K
 * @Date 2023/08/03 23:00
 * @Description 用户常量
 */
public class UserConst {
    /**
     * 用户token密钥
     */
    public static final String USER_TOKEN_SECRET = "kkuil";

    /**
     * 用户token过期时间
     */
    public static final int USER_TOKEN_EXPIRE_TIME = 30 * 60 * 1000;

    /**
     * 用户token刷新时间
     */
    public static final int USER_TOKEN_REFRESH_TIME = 10 * 60 * 1000;
}

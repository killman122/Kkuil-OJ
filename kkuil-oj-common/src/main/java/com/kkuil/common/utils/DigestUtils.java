package com.kkuil.common.utils;

import cn.hutool.crypto.digest.DigestUtil;

/**
 * @Author Kkuil
 * @Date 2023/08/05 12:30
 * @Description 加密工具类
 */
public class DigestUtils {

    /**
     * @param str 待加密字符串
     * @return 加密后的字符串
     * @description 使用MD5加密字符串
     */
    public static String str2Md5(String str) {
        return DigestUtil.md5Hex(str);
    }
}

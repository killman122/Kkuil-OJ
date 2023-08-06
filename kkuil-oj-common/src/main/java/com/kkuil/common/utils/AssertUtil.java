package com.kkuil.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author Kkuil
 * @Date 2023/08/06 16:00
 * @Description 断言工具类
 */
public class AssertUtil {

    /**
     * @param object 对象
     * @description 判断对象是否为空
     */
    public static void isObjNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
    }

    /**
     * @param object  对象
     * @param message 异常信息
     * @description 判断对象是否为空
     */
    public static void isObjNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * @param str 字符串
     * @description 判断字符串是否为空
     */
    public static void isStrNull(String str) {
        if (StringUtils.isEmpty(str)) {
            throw new IllegalArgumentException("参数不能为空");
        }
    }

    /**
     * @param str     字符串
     * @param message 异常信息
     * @description 判断字符串是否为空
     */
    public static void isStrNull(String str, String message) {
        if (StringUtils.isEmpty(str)) {
            throw new IllegalArgumentException(message);
        }
    }

}

package com.kkuil.common.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @Author Kkuil
 * @Date 2023/8/13 11:22
 * @Description 管理员权限验证
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface AuthAdmin {
}

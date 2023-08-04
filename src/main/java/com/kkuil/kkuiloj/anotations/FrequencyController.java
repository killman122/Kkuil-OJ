package com.kkuil.springboottemplate.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @Author kkuil
 * @Date 2023/07/29 20:00
 * @Description 频率控制器
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface FrequencyController {
}

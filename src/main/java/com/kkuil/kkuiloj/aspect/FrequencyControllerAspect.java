package com.kkuil.springboottemplate.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author kkuil
 * @Date 2023/07/29 20:00
 * @Description 频率控制器切面
 */
@Component
@Aspect
public class FrequencyControllerAspect {

    /**
     * @param joinPoint 切点
     * @return 切点返回值
     * @description 环绕通知
     */
    @Around("@annotation(com.kkuil.springboottemplate.anotations.FrequencyController)")
    public Object around(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        return null;
    }
}

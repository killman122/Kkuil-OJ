package com.kkuil.common.aspect;

import com.kkuil.common.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static com.kkuil.common.constant.UserConst.USER_TOKEN_IN_HEADER;
import static com.kkuil.common.constant.UserConst.USER_TOKEN_SECRET;

/**
 * @Author Kkuil
 * @Date 2023/8/13 11:23
 * @Description 管理员身份验证切面
 */
@Aspect
@Component
public class AuthAdminAspect {

    public static final String ADMIN_ROLE = "admin";

    @Pointcut("@target(com.kkuil.common.anotations.AuthAdmin)")
    public void authAdminJoinPoint() {
    }

    /**
     * @param joinPoint 切点
     * @return java.lang.Object
     * @throws Throwable 异常
     * @description 管理员身份验证切面
     */
    @Around("authAdminJoinPoint()")
    public ProceedingJoinPoint aroundAdvise(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader(USER_TOKEN_IN_HEADER);
        Claims parseToken = JwtUtils.parse(token, USER_TOKEN_SECRET);
        Object role = parseToken.get("role");
        if (ADMIN_ROLE.equals(role)) {
            return (ProceedingJoinPoint) joinPoint.proceed();
        } else {
            HttpServletResponse response = attributes.getResponse();
            assert response != null;
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return null;
        }
    }
}

package com.kkuil.kkuilojquestionservice.interceptors;

import com.kkuil.common.utils.AssertUtil;
import com.kkuil.common.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.AccessException;
import org.springframework.web.servlet.HandlerInterceptor;

import static com.kkuil.common.constant.UserConst.USER_TOKEN_IN_HEADER;
import static com.kkuil.common.constant.UserConst.USER_TOKEN_SECRET;

/**
 * @Author Kkuil
 * @Date 2023/07/29 20:00
 * @Description 登录拦截器
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws AccessException {
        return true;
    }
}
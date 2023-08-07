package com.kkuil.kkuilojuserservice.interceptors;

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

        // 1. 获取请求头中的token
        String pathInfo = request.getPathInfo();
        log.debug("请求路径: {}", pathInfo);
        String token = request.getHeader(USER_TOKEN_IN_HEADER);
        AssertUtil.isStrNull(token, "用户未登录");

        try {
            // 2. 验证token是否有效
            Claims userInfo = JwtUtils.parse(token, USER_TOKEN_SECRET);
            AssertUtil.isObjNull(userInfo, "无效token");

            return true;
        } catch (Exception e) {
            throw new AccessException(e.getMessage());
        }
    }
}
package com.kkuil.springboottemplate.filters;

import jakarta.servlet.*;
import org.springframework.core.Ordered;

import java.io.IOException;

/**
 * @Author kkuil
 * @Date 2023/07/29 20:00
 * @Description 权限过滤器
 */
public class AuthFilter implements Ordered, Filter {

    /**
     * @return 优先级
     * @description 过滤器优先级
     */
    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}

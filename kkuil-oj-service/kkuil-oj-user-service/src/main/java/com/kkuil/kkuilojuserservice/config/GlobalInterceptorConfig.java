package com.kkuil.kkuilojuserservice.config;

import com.kkuil.kkuilojuserservice.interceptors.AuthInterceptor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Kkuil
 * @Date 2023/08/05 10:00
 * @Description 全局拦截器配置
 */
@Configuration
@ConfigurationProperties(prefix = "cors")
@Data
public class GlobalInterceptorConfig implements WebMvcConfigurer {

    private static final List<String> AUTH_WHITE_LIST = new ArrayList<>();
    static {
        AUTH_WHITE_LIST.add("/login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .excludePathPatterns(AUTH_WHITE_LIST);
    }

}

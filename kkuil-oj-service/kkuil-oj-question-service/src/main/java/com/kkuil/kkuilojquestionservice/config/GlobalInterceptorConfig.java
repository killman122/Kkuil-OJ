package com.kkuil.kkuilojquestionservice.config;

import com.kkuil.kkuilojquestionservice.interceptors.AuthInterceptor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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
    }

    public static final String METHOD_SPLIT_CHAR = ",";

    private String mapping;
    private String allowedOrigins;
    private String allowedMethods;
    private String allowedHeaders;
    private String exposedHeaders;
    private boolean allowCredentials;
    private long maxAge;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .excludePathPatterns(AUTH_WHITE_LIST);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String[] methods = allowedMethods.split(METHOD_SPLIT_CHAR);
        registry.addMapping(mapping)
                .allowedOrigins(allowedOrigins)
                .allowedMethods(methods)
                .allowedHeaders(allowedHeaders);
    }
}

package com.kkuil.kkuilojjudgeservice.judge.bean;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Kkuil
 * @Date 2023/8/28 21:49
 * @Description docker客户端
 */
@Configuration
public class DockerClientBeans {

    /**
     * docker 登录邮箱
     */
    @Value("${docker.email}")
    private String dockerEmail;

    /**
     * docker 登录用户名
     */
    @Value("${docker.username}")
    private String dockerUsername;

    /**
     * docker 登录密码
     */
    @Value("${docker.password}")
    private String dockerPassword;

    /**
     * docker 宿主机
     */
    @Value("${docker.host}")
    private String dockerHost;

    private final DefaultDockerClientConfig config
            = DefaultDockerClientConfig.createDefaultConfigBuilder()
            .withRegistryEmail(dockerEmail)
            .withRegistryPassword(dockerUsername)
            .withRegistryUsername(dockerPassword)
            .withDockerHost(dockerHost)
            .build();

    @Bean
    public DockerClient dockerClient() {
        return DockerClientBuilder
                .getInstance(config)
                .build();
    }
}

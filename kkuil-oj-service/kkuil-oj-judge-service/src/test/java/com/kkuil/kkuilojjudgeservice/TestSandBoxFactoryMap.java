package com.kkuil.kkuilojjudgeservice;

import com.kkuil.common.utils.ResourceLoaderUtil;
import com.kkuil.kkuilojjudgeservice.judge.service.IQuestionJudgeService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Kkuil
 * @Date 2023/8/14 1:35
 * @Description 沙盒工厂测试类
 */
@Slf4j
@SpringBootTest
public class TestSandBoxFactoryMap {

    @Resource
    private IQuestionJudgeService questionJudgeService;

    @Test
    public void testSandBoxJudgeFactoryMap() {
        questionJudgeService.doJudge(null);
    }

    @Test
    public void testResourceLoader() {
        Object resource = ResourceLoaderUtil.getResource("classpath:sandbox-factory-map.properties");
        System.out.println("resource = " + resource);
    }
}

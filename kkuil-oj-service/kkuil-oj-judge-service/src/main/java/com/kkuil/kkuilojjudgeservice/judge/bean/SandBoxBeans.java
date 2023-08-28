package com.kkuil.kkuilojjudgeservice.judge.bean;

import com.kkuil.common.factory.resource.Resource;
import com.kkuil.common.utils.ResourceLoaderUtil;
import com.kkuil.kkuilojjudgeservice.judge.factory.AbstractSandBoxJudgeFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Kkuil
 * @Date 2023/8/14 0:57
 * @Description 沙箱bean
 */
@Configuration
@AllArgsConstructor
@Slf4j
public class SandBoxBeans {

    public static final String SANDBOX_FACTORY_MAP_PATH = "classpath:sandbox-factory-map.properties";

    private static final Map<String, AbstractSandBoxJudgeFactory> SAND_BOX_JUDGE_FACTORY_MAP = new HashMap<>(8);

    @Bean
    public Map<String, AbstractSandBoxJudgeFactory> sandBoxJudgeFactoryMap() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Resource<HashMap<String, String>> resource = (Resource<HashMap<String, String>>) ResourceLoaderUtil.getResource(SANDBOX_FACTORY_MAP_PATH);
        System.out.println("resource = " + resource.getValue());
        for (Map.Entry<String, String> factoryEntry : resource.getValue().entrySet()) {
            Class<?> sandboxJudgeFactoryClass = Class.forName(factoryEntry.getValue());
            AbstractSandBoxJudgeFactory abstractSandBoxJudgeFactory;
            try {
                abstractSandBoxJudgeFactory = (AbstractSandBoxJudgeFactory) sandboxJudgeFactoryClass.getConstructor().newInstance();
            } catch (InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            SAND_BOX_JUDGE_FACTORY_MAP.put(factoryEntry.getKey(), abstractSandBoxJudgeFactory);
        }
        System.out.println("SAND_BOX_JUDGE_FACTORY_MAP = " + SAND_BOX_JUDGE_FACTORY_MAP);
        return SAND_BOX_JUDGE_FACTORY_MAP;
    }
}

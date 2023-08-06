package com.kkuil.kkuilojuserservice;

import cn.hutool.core.util.RandomUtil;
import jakarta.annotation.Resource;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestUtil {

    @Resource
    private StringEncryptor encryptor;

    @Test
    void contextLoads() {
        String username = encryptor.encrypt("root");
        String database = encryptor.encrypt("db_kkuiloj");
        System.out.println(username);
        System.out.println(database);
    }

    @Test
    void testRandomUtil() {
        long id = Long.parseLong(RandomUtil.randomNumbers(10));
        System.out.println(id);
    }

}

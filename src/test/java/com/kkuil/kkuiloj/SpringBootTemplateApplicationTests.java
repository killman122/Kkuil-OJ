package com.kkuil.springboottemplate;

import jakarta.annotation.Resource;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootTemplateApplicationTests {

    @Resource
    private StringEncryptor encryptor;

    @Test
    void contextLoads() {
        String password = encryptor.encrypt("wwq5714806");
        System.out.println(password);
    }

}

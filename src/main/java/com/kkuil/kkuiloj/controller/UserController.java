package com.kkuil.springboottemplate.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kkuil
 * @Date 2023/07/29 20:00
 * @Description 用户控制器
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    /**
     * @return 用户名
     * @description 获取用户名
     */
    @GetMapping("/name")
    @Operation(summary = "用户控制器", description = "用户控制器")
    @Parameter(name = "name", description = "用户名")
    public String getName(String name) {
        log.info("获取用户名");
        return name;
    }
}

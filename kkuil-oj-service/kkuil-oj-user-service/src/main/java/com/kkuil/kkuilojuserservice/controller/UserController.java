package com.kkuil.kkuilojuserservice.controller;

import com.kkuil.common.utils.ResultUtil;
import com.kkuil.kkuilojuserservice.model.dto.UserLoginDTO;
import com.kkuil.kkuilojuserservice.model.vo.UserAuthVO;
import com.kkuil.kkuilojuserservice.service.ITbUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.kkuil.common.constant.UserConst.USER_TOKEN_IN_HEADER;

/**
 * @Author Kkuil
 * @Date 2023/07/29 20:00
 * @Description 用户控制器
 */
@Slf4j
@RestController
public class UserController {

    @Resource
    private ITbUserService userService;

    /**
     * @param userLoginDTO 用户登录数据传输对象
     * @return ResultUtil<String>
     * @description 用户登录
     */
    @PostMapping("/login")
    @Operation(summary = "用户登录", description = "用户登录")
    @Parameter(name = "userLoginDTO", description = "用户登录数据传输对象")
    public ResultUtil<String> login(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.login(userLoginDTO);
    }

    /**
     * @param token 用户token
     * @return ResultUtil<UserAuthVO>
     */
    @GetMapping("/auth")
    @Operation(summary = "用户授权", description = "用户授权")
    @Parameter(name = "token", description = "用户token")
    public ResultUtil<UserAuthVO> auth(@RequestHeader(USER_TOKEN_IN_HEADER) String token) {
        return userService.auth(token);
    }
}

package com.kkuil.kkuilojuserservice.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.kkuil.common.utils.ResultUtil;
import com.kkuil.kkuilojuserservice.model.dto.UserLoginDTO;
import com.kkuil.kkuilojuserservice.model.entity.TbUser;
import com.kkuil.kkuilojuserservice.model.vo.UserAuthVO;

/**
 * @Author Kkuil
 * @description 针对表【tb_user】的数据库操作Service
 * @Date 2023-08-04 00:17:16
 */
public interface TbUserService extends IService<TbUser> {

    /**
     * @param userLoginDTO 用户登录数据传输对象
     * @return token
     * @description 用户登录
     */
    ResultUtil<String> login(UserLoginDTO userLoginDTO);

    /**
     * @param token token
     * @return 用户名
     * @description 用户授权
     */
    ResultUtil<UserAuthVO> auth(String token);
}

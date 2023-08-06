package com.kkuil.kkuilojuserservice.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kkuil.common.model.user.UserTokenPayload;
import com.kkuil.common.utils.AssertUtil;
import com.kkuil.common.utils.DigestUtils;
import com.kkuil.common.utils.JwtUtils;
import com.kkuil.common.utils.ResultUtil;
import com.kkuil.kkuilojuserservice.mapper.TbUserMapper;
import com.kkuil.kkuilojuserservice.model.dto.UserLoginDTO;
import com.kkuil.kkuilojuserservice.model.entity.TbUser;
import com.kkuil.kkuilojuserservice.model.vo.UserAuthVO;
import com.kkuil.kkuilojuserservice.service.TbUserService;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

import static com.kkuil.common.constant.UserConst.*;

/**
 * @Author Kkuil
 * @description 针对表【tb_user】的数据库操作Service实现
 * @Date 2023-08-04 00:17:16
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser>
        implements TbUserService {

    /**
     * @param userLoginDTO 用户登录数据传输对象
     * @return token
     * @description 用户登录
     */
    @Override
    public ResultUtil<String> login(UserLoginDTO userLoginDTO) {
        // 1. 判断用户是否存在
        QueryWrapper<TbUser> userQueryWrapper = new QueryWrapper<TbUser>()
                .eq("username", userLoginDTO.getUsername());
        TbUser user = this.getOne(userQueryWrapper);
        if (user == null) {
            // 1.1 不存在，则创建用户
            TbUser newUser = new TbUser();
            newUser.setUsername(userLoginDTO.getUsername());
            newUser.setPassword(getEncryptPwd(userLoginDTO.getPassword()));
            boolean isSave = this.save(newUser);
            if (isSave) {
                UserTokenPayload payload = new UserTokenPayload();
                long id = Long.parseLong(RandomUtil.randomNumbers(10));
                payload
                        .setId(id)
                        .setUsername(userLoginDTO.getUsername());
                String token = JwtUtils.create(BeanUtil.beanToMap(payload, false, true), USER_TOKEN_SECRET, USER_TOKEN_TTL);
                return ResultUtil.success("注册成功", token);
            } else {
                return ResultUtil.error("用户创建失败");
            }
        }
        // 1.2 存在，则判断密码是否正确
        if (!user.getPassword().equals(getEncryptPwd(userLoginDTO.getPassword()))) {
            return ResultUtil.error("密码错误");
        }
        // 1.3 密码正确，则生成token
        UserTokenPayload payload = new UserTokenPayload();
        payload
                .setId(user.getId())
                .setUsername(user.getUsername());
        String token = JwtUtils.create(BeanUtil.beanToMap(payload, false, true), USER_TOKEN_SECRET, USER_TOKEN_TTL);
        return ResultUtil.success("登录成功", token);
    }

    /**
     * @param token token
     * @return 用户名
     * @description 用户授权
     */
    @Override
    public ResultUtil<UserAuthVO> auth(String token) {
        // 1. 解析token
        Claims parseToken = JwtUtils.parse(token, USER_TOKEN_SECRET);

        // 2. 获取用户id
        long id = (Long) parseToken.get("id");

        // 3. 判断用户是否存在
        TbUser user = this.getById(id);
        AssertUtil.isObjNull(user, "用户不存在");

        // 4. 刷新token
        UserTokenPayload payload = new UserTokenPayload();
        payload
                .setId(user.getId())
                .setUsername(user.getUsername());
        String newToken = JwtUtils.create(BeanUtil.beanToMap(payload, false, true), USER_TOKEN_SECRET, USER_TOKEN_TTL);

        // 5. 返回用户信息
        UserAuthVO userAuthVO = new UserAuthVO();
        userAuthVO
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setRole(user.getRole())
                .setToken(newToken);

        return ResultUtil.success(userAuthVO);
    }

    /**
     * @param password 用户密码
     * @return 加密后的密码
     */
    private String getEncryptPwd(String password) {
        String newPwd = password + USER_PWD_SALT_VALUE;
        return DigestUtils.str2Md5(newPwd);
    }
}





package com.kkuil.springboottemplate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kkuil.springboottemplate.mapper.UserMapper;
import com.kkuil.springboottemplate.model.entity.User;
import com.kkuil.springboottemplate.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author kkuil
 * @Date 2023/07/29 20:00
 * @Description UserServiceImpl
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}

package com.kkuil.springboottemplate.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkuil.springboottemplate.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author kkuil
 * @Date 2023/07/29 20:00
 * @Description UserMapper
 */
public interface UserMapper extends BaseMapper<User> {
}

package com.kkuil.kkuilojuserservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkuil.kkuilojuserservice.model.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 小K
 * @description 针对表【tb_user】的数据库操作Mapper
 * @createDate 2023-08-06 15:52:12
 * @Entity com.kkuil.kkuilojuserservice.model.entity.TbUser
 */
@Mapper
public interface TbUserMapper extends BaseMapper<TbUser> {

}





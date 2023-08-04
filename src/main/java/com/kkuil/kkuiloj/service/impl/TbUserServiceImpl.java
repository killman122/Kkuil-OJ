package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.TbUser;
import generator.service.TbUserService;
import generator.mapper.TbUserMapper;
import org.springframework.stereotype.Service;

/**
* @author 小K
* @description 针对表【tb_user】的数据库操作Service实现
* @createDate 2023-08-04 00:17:16
*/
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser>
    implements TbUserService{

}





package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.TbQuestion;
import generator.service.TbQuestionService;
import generator.mapper.TbQuestionMapper;
import org.springframework.stereotype.Service;

/**
* @author 小K
* @description 针对表【tb_question】的数据库操作Service实现
* @createDate 2023-08-07 22:09:39
*/
@Service
public class TbQuestionServiceImpl extends ServiceImpl<TbQuestionMapper, TbQuestion>
    implements TbQuestionService{

}





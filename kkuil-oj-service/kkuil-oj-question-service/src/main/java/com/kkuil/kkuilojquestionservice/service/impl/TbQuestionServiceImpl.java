package com.kkuil.kkuilojquestionservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kkuil.kkuilojquestionservice.model.entity.TbQuestion;
import com.kkuil.kkuilojquestionservice.mapper.TbQuestionMapper;
import com.kkuil.kkuilojquestionservice.service.TbQuestionService;
import org.springframework.stereotype.Service;

/**
* @author 小K
* @description 针对表【tb_question】的数据库操作Service实现
* @Date 2023-08-08 10:47:22
*/
@Service
public class TbQuestionServiceImpl extends ServiceImpl<TbQuestionMapper, TbQuestion>
    implements TbQuestionService{

}

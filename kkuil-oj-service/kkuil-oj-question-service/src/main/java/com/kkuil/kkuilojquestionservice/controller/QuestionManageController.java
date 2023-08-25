package com.kkuil.kkuilojquestionservice.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kkuil.common.anotations.AuthAdmin;
import com.kkuil.common.model.page.PageRes;
import com.kkuil.common.utils.ResultUtil;
import com.kkuil.kkuilojquestionservice.model.dto.AddQuestionDTO;
import com.kkuil.kkuilojquestionservice.model.dto.UpdateQuestionDTO;
import com.kkuil.kkuilojquestionservice.model.entity.TbQuestion;
import com.kkuil.kkuilojquestionservice.service.ITbQuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @Author Kkuil
 * @Date 2023/07/29 20:00
 * @Description 问题控制器
 */
@Slf4j
@RestController
public class QuestionManageController {

    @Resource
    private ITbQuestionService questionService;

    /**
     * @param id       问题id
     * @param current  当前页
     * @param pageSize 每页大小
     * @return 问题列表
     * @description 获取问题列表
     */
    @GetMapping("/list")
    @AuthAdmin
    @Operation(summary = "分页获取问题", description = "分页获取问题")
    @Parameters({
            @Parameter(name = "id", description = "问题id"),
            @Parameter(name = "current", description = "当前页"),
            @Parameter(name = "pageSize", description = "每页大小")
    })
    public ResultUtil<PageRes<List<TbQuestion>>> page(String id, int current, int pageSize) {
        log.info("id: {}, current: {}, pageSize: {}", id, current, pageSize);
        Page<TbQuestion> pageInfo = new Page<>();
        pageInfo.setCurrent(current);
        pageInfo.setSize(pageSize);
        QueryWrapper<TbQuestion> questionWrapper = new QueryWrapper<>();
        questionWrapper
                .like("id", id);
        IPage<TbQuestion> pageWithLimit = questionService.page(pageInfo, questionWrapper);
        List<TbQuestion> pageWithNotLimit = questionService.list(questionWrapper);
        PageRes<List<TbQuestion>> pageRes = new PageRes<>();
        pageRes
                .setPageSize(pageWithLimit.getSize())
                .setCurrent(pageWithLimit.getCurrent())
                .setTotal((long) pageWithNotLimit.size())
                .setData(pageWithLimit.getRecords());
        return ResultUtil.success("获取成功", pageRes);
    }

    /**
     * @param addQuestionDTO 添加问题数据传输对象
     * @return 是否添加成功
     * @description 添加问题
     */
    @PostMapping("/add")
    @AuthAdmin
    @Operation(summary = "添加问题", description = "添加问题")
    @Parameter(name = "addQuestionDTO", description = "添加问题数据传输对象")
    public ResultUtil<Boolean> add(@RequestBody AddQuestionDTO addQuestionDTO) {
        boolean isAllNotEmpty = ObjectUtil.isAllNotEmpty(addQuestionDTO);
        if (!isAllNotEmpty) {
            return ResultUtil.error("必填字段不能为空", false);
        }
        TbQuestion tbQuestion = BeanUtil.copyProperties(addQuestionDTO, TbQuestion.class);
        boolean isSave;
        try {
            isSave = questionService.save(tbQuestion);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (isSave) {
            return ResultUtil.success("添加成功", true);
        } else {
            return ResultUtil.error("添加失败", false);
        }
    }

    /**
     * @param id 问题id
     * @return 是否删除成功
     * @description 删除问题
     */
    @DeleteMapping("/{id}")
    @AuthAdmin
    @Operation(summary = "删除问题", description = "删除问题")
    @Parameter(name = "id", description = "问题id")
    public ResultUtil<Boolean> del(@PathVariable("id") Long id) {
        boolean isSave = questionService.removeById(id);
        if (isSave) {
            return ResultUtil.success("删除成功", true);
        } else {
            return ResultUtil.error("删除失败", false);
        }
    }

    /**
     * @param ids 问题id
     * @return 是否删除成功
     * @description 删除问题
     */
    @DeleteMapping
    @AuthAdmin
    @Operation(summary = "删除一批问题", description = "删除一批问题")
    @Parameter(name = "ids", description = "问题ids")
    public ResultUtil<Boolean> del(String ids) {
        boolean isSave = questionService.removeByIds(Collections.singleton(ids));
        if (isSave) {
            return ResultUtil.success("删除成功", true);
        } else {
            return ResultUtil.error("删除失败", false);
        }
    }

    /**
     * @param updateQuestionDTO 修改问题数据传输对象
     * @return 是否修改成功
     * @description 修改问题
     */
    @PutMapping
    @AuthAdmin
    @Operation(summary = "修改问题", description = "修改问题")
    @Parameter(name = "updateQuestionDTO", description = "修改问题数据传输对象")
    public ResultUtil<Boolean> update(@RequestBody UpdateQuestionDTO updateQuestionDTO) {
        TbQuestion tbQuestion = BeanUtil.copyProperties(updateQuestionDTO, TbQuestion.class);
        boolean isSave = questionService.updateById(tbQuestion);
        if (isSave) {
            return ResultUtil.success("修改成功", true);
        } else {
            return ResultUtil.error("修改失败", false);
        }
    }

    /**
     * @param id 问题id
     * @return 查询的数据
     * @description 查询问题
     */
    @GetMapping("/{id}")
    @AuthAdmin
    @Operation(summary = "查询问题", description = "查询问题")
    @Parameter(name = "id", description = "查询问题数据传输对象")
    public ResultUtil<TbQuestion> select(@PathVariable("id") Long id) {
        return ResultUtil.success("查询成功", questionService.getById(id));
    }


}

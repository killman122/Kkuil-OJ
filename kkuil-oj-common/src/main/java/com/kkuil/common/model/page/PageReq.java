package com.kkuil.common.model.page;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @param <DataType>
 * @Description 分页请求携带的参数
 * @Author kkuil
 * @Date 2023/08/11 12:00
 */
@Data
@Accessors(chain = true)
public class PageReq<DataType> {
    /**
     * 当前页
     */
    private Long current;

    /**
     * 每页大小
     */
    private Long pageSize;

    /**
     * 数据
     */
    private DataType data;
}

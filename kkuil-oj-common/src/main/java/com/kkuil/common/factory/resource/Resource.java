package com.kkuil.common.factory.resource;

import lombok.Data;

/**
 * @Author Kkuil
 * @Date 2023/8/14 17:55
 * @Description 资源实体
 */
@Data
public class Resource<DataType> {
    /**
     * 资源值
     */
    private DataType value;
}

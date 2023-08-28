package com.kkuil.common.factory.resource.enums;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author 小K
 * @Date 2023/08/25 16:27
 * @Description 资源类型实体
 */
@Data
@Accessors(chain = true)
public class ResourceTypeEntity<DataType> {
    /**
     * 资源类型名称
     */
    private String name;

    /**
     * 资源类型值
     */
    private DataType[] values;
}

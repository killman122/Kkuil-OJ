package com.kkuil.common.factory.resource.enums;

import lombok.Data;
import lombok.experimental.Accessors;

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

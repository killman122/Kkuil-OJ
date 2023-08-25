package com.kkuil.common.factory.path.model;

import lombok.Data;

/**
 * @Author Kkuil
 * @Date 2023/8/14 16:21
 * @Description 路径信息
 */
@Data
public class PathInfo {
    /**
     * 全路径
     */
    private String fullPath;

    /**
     * 前缀
     */
    private String prefix;

    /**
     * 扩展名
     */
    private String ext;

    /**
     * 路径类型
     */
    private String pathType;

    /**
     * 主路径
     */
    private String mainPath;

    /**
     * 资源类型
     */
    private String resourceType;
}

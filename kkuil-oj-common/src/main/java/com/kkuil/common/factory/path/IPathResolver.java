package com.kkuil.common.factory.path;

import com.kkuil.common.factory.path.model.PathInfo;

/**
 * @Author Kkuil
 * @Date 2023/8/14 16:20
 * @Description 路径解析器接口
 */
public interface IPathResolver {
    /**
     * 解析路径
     *
     * @param path 路径
     * @return 解析后的路径
     */
    PathInfo resolve(String path);
}

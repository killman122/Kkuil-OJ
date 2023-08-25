package com.kkuil.common.factory.resource.strategy;

import com.kkuil.common.factory.path.IPathResolver;
import com.kkuil.common.factory.path.impl.resolver.PathResolver;
import com.kkuil.common.factory.path.model.PathInfo;

/**
 * @Author Kkuil
 * @Date 2023/8/15 1:00
 * @Description 资源策略接口
 */
public interface IResourceStrategy<DataType> {

    /**
     * 默认路径解析器
     */
    public static
    IPathResolver DEFAULT_PATH_RESOLVER = new PathResolver();

    /**
     * 加载资源
     *
     * @param pathInfo 资源路径信息
     * @return 资源值
     */
    DataType load(PathInfo pathInfo);
}

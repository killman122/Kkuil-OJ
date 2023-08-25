package com.kkuil.common.factory.resource;

import com.kkuil.common.factory.path.model.PathInfo;

/**
 * @Author Kkuil
 * @Date 2023/8/14 16:51
 * @Description 资源加载器接口
 */
public interface IResourceLoader {
    /**
     * 加载资源
     *
     * @param pathInfo 资源路径信息
     * @return 资源
     */
    Object load(PathInfo pathInfo);
}

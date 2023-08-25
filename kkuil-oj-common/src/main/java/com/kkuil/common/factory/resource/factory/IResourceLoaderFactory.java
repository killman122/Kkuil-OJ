package com.kkuil.common.factory.resource.factory;

import com.kkuil.common.factory.model.ResourceLoader;
import com.kkuil.common.factory.path.IPathResolver;

/**
 * @Author Kkuil
 * @Date 2023/8/14 16:57
 * @Description 资源加载器工厂
 */
public interface IResourceLoaderFactory {
    /**
     * 获取资源加载器
     *
     * @param path         路径
     * @param pathResolver 路径解析器
     * @return 资源加载器
     */
    ResourceLoader getResourceLoader(IPathResolver pathResolver, String path);

    /**
     * 获取资源加载器
     *
     * @param path         路径
     * @return 资源加载器
     */
    ResourceLoader getResourceLoader(String path);
}

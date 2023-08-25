package com.kkuil.common.utils;

import com.kkuil.common.factory.model.ResourceLoader;
import com.kkuil.common.factory.path.IPathResolver;
import com.kkuil.common.factory.resource.IResourceLoader;
import com.kkuil.common.factory.resource.factory.IResourceLoaderFactory;
import com.kkuil.common.factory.resource.factory.ResourceLoaderFactoryServiceImpl;

/**
 * @Author Kkuil
 * @Date 2023/8/14 11:07
 * @Description 资源工具类
 */
public class ResourceLoaderUtil {

    private static final IResourceLoaderFactory RESOURCE_LOADER_FACTORY;

    static {
        RESOURCE_LOADER_FACTORY = new ResourceLoaderFactoryServiceImpl();
    }

    /**
     * 获取资源
     *
     * @param path 资源路径
     * @return 资源
     */
    public static Object getResource(String path) {
        ResourceLoader resourceLoader = RESOURCE_LOADER_FACTORY.getResourceLoader(path);
        return getRes(resourceLoader);
    }

    /**
     * 获取资源
     *
     * @param path 资源路径
     * @param pathResolver 路径解析器
     * @return 资源
     */
    public static Object getResource(IPathResolver pathResolver, String path) {
        ResourceLoader resourceLoader = RESOURCE_LOADER_FACTORY.getResourceLoader(pathResolver, path);
        return getRes(resourceLoader);
    }

    private static Object getRes(ResourceLoader resourceLoader) {
        IResourceLoader loader = resourceLoader.getLoader();
        return loader.load(resourceLoader.getPathInfo());
    }

}

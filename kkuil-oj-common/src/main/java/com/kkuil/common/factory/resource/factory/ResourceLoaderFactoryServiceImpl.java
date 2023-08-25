package com.kkuil.common.factory.resource.factory;

import com.kkuil.common.factory.model.ResourceLoader;
import com.kkuil.common.factory.path.IPathResolver;
import com.kkuil.common.factory.path.impl.resolver.PathResolver;
import com.kkuil.common.factory.path.model.PathInfo;
import com.kkuil.common.factory.resource.IResourceLoader;
import com.kkuil.common.factory.resource.exception.ResourceLoaderException;
import com.kkuil.common.factory.resource.impl.loader.ImageResourceLoader;
import com.kkuil.common.factory.resource.impl.loader.TextResourceLoader;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Kkuil
 * @Date 2023/8/14 16:59
 * @Description 资源加载器工厂实现类
 */
@Service
public class ResourceLoaderFactoryServiceImpl implements IResourceLoaderFactory {

    private static final IPathResolver DEFAULT_PATH_RESOLVER = new PathResolver();

    public static final Map<String, IResourceLoader> RESOURCE_LOADER_MAP = new HashMap<>(8);

    static {
        RESOURCE_LOADER_MAP.put("image", new ImageResourceLoader());
        RESOURCE_LOADER_MAP.put("text", new TextResourceLoader());
    }

    /**
     * 获取资源加载器
     *
     * @param path         路径信息
     * @param pathResolver 路径解析器
     * @return 资源加载器
     */
    @Override
    public ResourceLoader getResourceLoader(IPathResolver pathResolver, String path) {
        PathInfo pathInfo = pathResolver.resolve(path);
        return ResourceLoader.builder()
                .loader(getLoader(pathInfo))
                .pathInfo(pathInfo)
                .build();
    }

    /**
     * 获取资源加载器
     *
     * @param path 路径信息
     * @return 资源加载器
     */
    @Override
    public ResourceLoader getResourceLoader(String path) {
        PathInfo pathInfo = DEFAULT_PATH_RESOLVER.resolve(path);
        return ResourceLoader.builder()
                .loader(getLoader(pathInfo))
                .pathInfo(pathInfo)
                .build();
    }

    private IResourceLoader getLoader(PathInfo pathInfo) {
        String resourceType = pathInfo.getResourceType();
        if (StringUtils.isEmpty(resourceType)) {
            throw new ResourceLoaderException("资源类型为空");
        }
        IResourceLoader loader = RESOURCE_LOADER_MAP.get(resourceType);
        if (loader == null) {
            throw new ResourceLoaderException("未找到对应的资源加载器");
        }
        return loader;
    }
}

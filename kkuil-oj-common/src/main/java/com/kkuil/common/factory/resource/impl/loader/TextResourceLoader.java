package com.kkuil.common.factory.resource.impl.loader;

import com.kkuil.common.factory.path.model.PathInfo;
import com.kkuil.common.factory.resource.IResourceLoader;
import com.kkuil.common.factory.resource.Resource;
import com.kkuil.common.factory.resource.exception.NotSupportException;
import com.kkuil.common.factory.resource.strategy.impl.PropertiesResourceStrategy;

import java.util.Map;

/**
 * @Author Kkuil
 * @Date 2023/8/14 18:29
 * @Description 文本类型加载器
 */
public class TextResourceLoader implements IResourceLoader {

    /**
     * 加载资源
     *
     * @param pathInfo 资源路径信息
     * @return 资源
     */
    @Override
    public Resource<Object> load(PathInfo pathInfo) {
        String ext = pathInfo.getExt();
        System.out.println("pathInfo.getResourceType() = " + ext);
        Resource<Object> resource = new Resource<>();
        switch (ext) {
            case "properties":
                Map<String, String> value = new PropertiesResourceStrategy().load(pathInfo);
                resource.setValue(value);
                return resource;
            default:
                throw new NotSupportException("不支持的文本类型");
        }
    }
}

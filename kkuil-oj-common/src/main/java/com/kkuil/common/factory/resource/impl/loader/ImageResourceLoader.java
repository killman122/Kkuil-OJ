package com.kkuil.common.factory.resource.impl.loader;

import com.kkuil.common.factory.path.model.PathInfo;
import com.kkuil.common.factory.resource.IResourceLoader;
import com.kkuil.common.factory.resource.enums.ImageEnum;
import com.kkuil.common.factory.resource.enums.ResourceType;

/**
 * @Author Kkuil
 * @Date 2023/8/14 17:03
 * @Description Classpath加载器
 */
public class ImageResourceLoader implements IResourceLoader {
    /**
     * 加载资源
     *
     * @param pathInfo 资源路径
     * @return 资源
     */
    @Override
    public Object load(PathInfo pathInfo) {
        ImageEnum[] image = ResourceType.IMAGE.getValues();
        return null;
    }
}

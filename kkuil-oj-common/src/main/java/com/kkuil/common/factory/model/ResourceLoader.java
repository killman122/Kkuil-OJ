package com.kkuil.common.factory.model;

import com.kkuil.common.factory.path.model.PathInfo;
import com.kkuil.common.factory.resource.IResourceLoader;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author Kkuil
 * @Date 2023/8/14 17:50
 * @Description 资源加载器
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ResourceLoader {
    /**
     * 资源路径信息
     */
    private PathInfo pathInfo;

    /**
     * 资源加载器
     */
    private IResourceLoader loader;
}

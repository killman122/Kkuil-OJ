package com.kkuil.common.factory.resource.strategy.impl;

import com.kkuil.common.factory.path.model.PathInfo;
import com.kkuil.common.factory.resource.strategy.IResourceStrategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Author Kkuil
 * @Date 2023/8/15 1:01
 * @Description properties资源类型策略
 */
public class PropertiesResourceStrategy implements IResourceStrategy<Map<String, String>> {

    public static final int HASH_MAP_DEFAULT_CAPACITY = 8;

    /**
     * 加载资源
     *
     * @param path 资源路径
     * @return 资源值
     */
    @Override
    public Map<String, String> load(PathInfo pathInfo) {
        String mainPath = pathInfo.getMainPath();
        InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(mainPath);
        Properties properties = new Properties();
        HashMap<String, String> map = new HashMap<>(HASH_MAP_DEFAULT_CAPACITY);
        try {
            properties.load(resourceStream);
            for (Map.Entry<Object, Object> entrySet : properties.entrySet()) {
                String key = entrySet.getKey().toString();
                String value = entrySet.getValue().toString();
                map.put(key, value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}

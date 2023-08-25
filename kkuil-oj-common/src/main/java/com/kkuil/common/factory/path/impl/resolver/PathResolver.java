package com.kkuil.common.factory.path.impl.resolver;

import com.kkuil.common.factory.path.IPathResolver;
import com.kkuil.common.factory.path.exception.PathException;
import com.kkuil.common.factory.path.model.PathInfo;
import com.kkuil.common.factory.resource.enums.ImageEnum;
import com.kkuil.common.factory.resource.enums.ResourceType;
import com.kkuil.common.factory.resource.enums.TextEnum;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @Author Kkuil
 * @Date 2023/8/14 16:24
 * @Description 路径解析器实现类
 */
@Service
public class PathResolver implements IPathResolver {

    /**
     * 路径分隔符
     */
    public static final String PATH_SPLIT_CHAR = ":";

    /**
     * 资源分隔符
     */
    public static final String RESOURCE_SPLIT_CHAR = "\\\\";

    /**
     * 文件扩展名分隔符
     */
    public static final String EXT_SPLIT_CHAR = ".";

    /**
     * 解析路径
     *
     * @param path 路径
     * @return 解析后的路径
     */
    @Override
    public PathInfo resolve(String path) {
        if (path == null || path.length() == 0) {
            return null;
        }
        if (!path.contains(PATH_SPLIT_CHAR)) {
            throw new PathException("路径格式异常，缺少了分隔符" + PATH_SPLIT_CHAR);
        }
        if (!path.contains(EXT_SPLIT_CHAR)) {
            throw new PathException("路径格式异常，缺少了分隔符" + EXT_SPLIT_CHAR);
        }
        PathInfo pathInfo = new PathInfo();
        pathInfo.setFullPath(path);
        pathInfo.setPrefix(getPrefix(path));
        pathInfo.setExt(getExt(path));
        pathInfo.setPathType(getPathType(path));
        pathInfo.setMainPath(getMainPath(path));
        pathInfo.setResourceType(getResourceType(path));
        return pathInfo;
    }

    /**
     * 获取资源前缀
     *
     * @param path 资源路径
     * @return 前缀
     */
    public static String getPrefix(String path) {
        return path.split(PATH_SPLIT_CHAR)[0];
    }

    /**
     * 获取资源扩展名
     *
     * @param path 资源路径
     * @return 扩展名
     */
    public static String getExt(String path) {
        String splitStr = "\\.";
        String[] splitArr = path.split(splitStr);
        return splitArr[splitArr.length - 1];
    }

    /**
     * 获取路径类型
     *
     * @param path 资源路径
     * @return 路径类型
     */
    public static String getPathType(String path) {
        return path.split(PATH_SPLIT_CHAR)[0];
    }

    /**
     * 获取主路径
     *
     * @param path 资源路径
     * @return 主路径
     */
    public static String getMainPath(String path) {
        String[] splitArr = path.split(PATH_SPLIT_CHAR);
        String[] tmpArr = Arrays.copyOfRange(splitArr, 1, splitArr.length);
        return String.join(":", tmpArr);
    }

    /**
     * 获取资源类型
     *
     * @param path 资源路径
     * @return 资源类型
     */
    public static String getResourceType(String path) {
        String splitStr = "\\.";
        String[] splitArr = path.split(splitStr);
        if (splitArr.length == 0) {
            throw new PathException("路径格式异常或该路径不是资源路径");
        }
        String resourceSuffix = splitArr[splitArr.length - 1];
        Object[] imageValues = Arrays.stream(ResourceType.IMAGE.getValues()).map(ImageEnum::getType).toArray();
        boolean isContainInImage = ArrayUtils.contains(imageValues, resourceSuffix);
        if (isContainInImage) {
            return ResourceType.IMAGE.getName();
        }
        Object[] textValues = Arrays.stream(ResourceType.TEXT.getValues()).map(TextEnum::getType).toArray();
        boolean isContainInText = ArrayUtils.contains(textValues, resourceSuffix);
        if (isContainInText) {
            return ResourceType.TEXT.getName();
        }
        return resourceSuffix;
    }
}

package com.kkuil.common.factory.resource.enums;

/**
 * @Author Kkuil
 * @Date 2023/8/14 16:34
 * @Description 资源类型
 */
public class ResourceType {

    public static final ResourceTypeEntity<ImageEnum> IMAGE;
    public static final ResourceTypeEntity<TextEnum> TEXT;

    static {
        IMAGE = new ResourceTypeEntity<>();
        IMAGE
                .setName("image")
                .setValues(ImageEnum.values());

        TEXT = new ResourceTypeEntity<>();
        TEXT
                .setName("text")
                .setValues(TextEnum.values());
    }
}

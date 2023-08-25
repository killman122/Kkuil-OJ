package com.kkuil.common.factory.resource.enums;

/**
 * @Author Kkuil
 * @Date 2023/8/14 16:36
 * @Description 图片资源枚举
 */
public enum ImageEnum {

    /**
     * jpg
     */
    JPG("jpg"),

    /**
     * jpeg
     */
    JPEG("jpeg"),

    /**
     * png
     */
    PNG("png"),

    /**
     * gif
     */
    GIF("gif"),

    /**
     * bmp
     */
    BMP("bmp"),

    /**
     * webp
     */
    WEBP("webp"),

    /**
     * ico
     */
    ICO("ico"),

    /**
     * tiff
     */
    TIFF("tiff");

    private final String type;

    ImageEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

package com.kkuil.common.factory.resource.enums;

/**
 * @Author Kkuil
 * @Date 2023/8/14 16:39
 * @Description 文本格式枚举
 */
public enum TextEnum {

    /**
     * txt
     */
    TXT("txt"),

    /**
     * md
     */
    MD("md"),

    /**
     * html
     */
    HTML("html"),

    /**
     * css
     */
    CSS("css"),

    /**
     * js
     */
    JS("js"),

    /**
     * java
     */
    JAVA("java"),

    /**
     * c
     */
    C("c"),

    /**
     * cpp
     */
    CPP("cpp"),

    /**
     * py
     */
    PY("py"),

    /**
     * properties
     */
    PROPERTIES("properties"),

    /**
     * yaml
     */
    YML("yml"),

    /**
     * yaml
     */
    YAML("yaml");

    private final String type;

    TextEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

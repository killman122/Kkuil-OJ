package com.kkuil.common.enums;

/**
 * @Author Kkuil
 * @Date 2023/8/12 0:31
 * @Description 执行结果枚举
 */
public enum ExecResultEnum {
    /**
     * 0-通过
     */
    PASS("0"),

    /**
     * 1-未通过
     */
    UN_PASS("1");

    private final String value;

    ExecResultEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

package com.kkuil.common.enums;

/**
 * @Author Kkuil
 * @Date 2023/08/09 18:00
 * @Description 判题异常枚举
 */
public enum JudgeExceptionEnum {
    /**
     * 系统异常
     */
    SYSTEM(5000),
    /**
     * 编译异常
     */
    COMPILE(5001),
    /**
     * 运行时异常
     */
    RUNTIME(5002),
    /**
     * 超出时间限制异常
     */
    OUT_OF_TIME(5003),
    /**
     * 超出内存限制异常
     */
    OUT_OF_MEMORY(5004),
    /**
     * 代码超出异常
     */
    OUT_OF_MAX_CODE_LEN(5005),
    /**
     * 答案错误异常
     */
    WRONG_ANSWER(5006);

    private final int value;

    JudgeExceptionEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

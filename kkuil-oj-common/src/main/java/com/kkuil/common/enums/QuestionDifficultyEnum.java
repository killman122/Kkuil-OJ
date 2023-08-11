package com.kkuil.common.enums;

/**
 * @Author Kkuil
 * @Date 2023/8/12 0:31
 * @Description 题目难度枚举
 */
public enum QuestionDifficultyEnum {
    /**
     * 0-入门
     */
    GREEN_HAND(0L, "入门"),

    /**
     * 1-简单
     */
    EASY(1L, "简单"),

    /**
     * 2-中等
     */
    MEDIUM(2L, "中等"),

    /**
     * 3-偏难
     */
    DIFFICULT(3L, "偏难"),

    /**
     * 4-困难
     */
    HARD(4L, "困难"),

    /**
     * 5-地狱
     */
    HELL(5L, "地狱");

    private final Long value;
    private final String name;

    QuestionDifficultyEnum(Long value, String name) {
        this.value = value;
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}

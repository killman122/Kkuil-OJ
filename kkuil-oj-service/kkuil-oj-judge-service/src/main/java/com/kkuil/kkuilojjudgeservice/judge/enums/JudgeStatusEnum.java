package com.kkuil.kkuilojjudgeservice.judge.enums;

/**
 * @Author Kkuil
 * @Date 2023/08/09 18:00
 * @Description 当前代码提交状态枚举
 */
public enum JudgeStatusEnum {

    /**
     * 已接收
     */
    RECEIVED(0, "已接收"),
    /**
     * 正在执行
     */
    RUNNING(1, "正在执行"),
    /**
     * 执行完成
     */
    FINISHED(2, "执行完成");


    private final int value;
    private final String name;

    JudgeStatusEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}

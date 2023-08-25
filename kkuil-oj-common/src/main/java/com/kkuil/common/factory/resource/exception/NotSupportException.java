package com.kkuil.common.factory.resource.exception;

/**
 * @Author Kkuil
 * @Date 2023/8/15 0:57
 * @Description 不支持类型异常
 */
public class NotSupportException extends RuntimeException {
    public NotSupportException(String message) {
        super(message);
    }
}

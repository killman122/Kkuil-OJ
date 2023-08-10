package com.kkuil.common.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author Kkuil
 * @Date 2023/08/03 23:00
 * @Description 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @param e Exception
     * @return ResponseEntity
     * @description 处理所有不可知的异常
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // 处理异常的逻辑
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}

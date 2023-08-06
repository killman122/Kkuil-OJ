package com.kkuil.common.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @Author Kkuil
 * @Date 2023/08/03 23:00
 * @Description 返回结果工具类
 */
@Data
public class ResultUtil<DataType> {
    /**
     * 响应码
     */
    private HttpStatus code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应数据
     */
    private DataType data;

    public ResultUtil(HttpStatus code, String message, DataType data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultUtil<Object> success() {
        return new ResultUtil<>(HttpStatus.OK, "success", null);
    }

    public static <DT> ResultUtil<DT> success(DT data) {
        return new ResultUtil<>(HttpStatus.OK, "success", data);
    }

    public static <DT> ResultUtil<DT> success(String message, DT data) {
        return new ResultUtil<>(HttpStatus.OK, message, data);
    }

    public static ResultUtil<Object> error() {
        return new ResultUtil<>(HttpStatus.BAD_REQUEST, "error", null);
    }

    public static ResultUtil error(String message) {
        return new ResultUtil<>(HttpStatus.BAD_REQUEST, message, null);
    }

    public static <DT> ResultUtil<DT> error(DT data) {
        return new ResultUtil<>(HttpStatus.BAD_REQUEST, "error", data);
    }

    public static <DT> ResultUtil<DT> error(String message, DT data) {
        return new ResultUtil<>(HttpStatus.BAD_REQUEST, message, data);
    }
}

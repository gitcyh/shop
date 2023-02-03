package com.cyh.shop.exception;

import lombok.Getter;

/**
 * 自定义异常  运行时异常
 */
@Getter
@SuppressWarnings("all")
public class ServiceException extends RuntimeException {

    private Integer code;

    public ServiceException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

}
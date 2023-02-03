package com.cyh.shop.exception;

import com.cyh.shop.util.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class GlobalExceptionHandler {

    /**
     * @ExceptionHandler相当于controller的@RequestMapping
     * 如果抛出的的是ServiceException，则调用该方法
     * @param se 业务异常
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result handle(ServiceException se){
        return Result.error(se.getCode(),se.getMessage());
    }

}

package com.xians.yaco.exception;

import org.springframework.http.HttpStatus;

/**
 * 错误请求引起的异常。
 *
 * @author XIANS
 */
public class BadRequestException extends BaseException {
    //错误的请求异常
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
    //获取当前的状态
    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}

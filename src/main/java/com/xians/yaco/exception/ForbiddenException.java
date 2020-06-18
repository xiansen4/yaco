package com.xians.yaco.exception;

import org.springframework.http.HttpStatus;

/**
 * 访问禁止资源导致的异常.
 *
 * @author XIANS
 */
public class ForbiddenException extends BaseException {

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }
    //获取当前的状态
    @Override
    public HttpStatus getStatus() {
        return HttpStatus.FORBIDDEN;
    }
}

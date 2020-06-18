package com.xians.yaco.exception;

import org.springframework.http.HttpStatus;

/**
 * 找不到实体类的异常
 *
 * @author XIANS
 */
public class NotFoundException extends BaseException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}

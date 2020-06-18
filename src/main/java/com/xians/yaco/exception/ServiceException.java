package com.xians.yaco.exception;

import org.springframework.http.HttpStatus;

/**
 *服务层引起的异常
 *
 * @author XIANS
 */
public class ServiceException extends BaseException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}

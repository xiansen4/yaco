package com.xians.yaco.exception;

/**
 * 由实体存在引起的异常。
 * Exception caused by entity existence already.
 *
 * @author XIANS
 */
public class AlreadyExistsException extends BadRequestException {

    public AlreadyExistsException(String message) {
        super(message);
    }

    public AlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

}

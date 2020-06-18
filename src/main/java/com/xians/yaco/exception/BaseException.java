package com.xians.yaco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * 项目最基础的异常类
 *
 * @author XIANS
 */
public abstract class BaseException extends RuntimeException {

    /**
     * Error 错误数据.
     */
    private Object errorData;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    @NonNull
    public abstract HttpStatus getStatus();

    @Nullable
    public Object getErrorData() {
        return errorData;
    }

    /**
     * Sets error errorData.
     * 设置错误
     *
     * @param errorData error data
     * @return current exception.
     */
    @NonNull
    public BaseException setErrorData(@Nullable Object errorData) {
        this.errorData = errorData;
        return this;
    }
}

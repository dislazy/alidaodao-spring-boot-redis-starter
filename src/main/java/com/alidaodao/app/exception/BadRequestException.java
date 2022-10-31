package com.alidaodao.app.exception;

import java.io.Serializable;

/**
 * @author jack
 * @since 2022-10-31
 */
public class BadRequestException extends RuntimeException implements Serializable {


    protected ResponseCodeEnum resultCode;

    public BadRequestException(ResponseCodeEnum errorCode) {
        super(errorCode.getCnName());
        this.resultCode = errorCode;
    }

    public BadRequestException(ResponseCodeEnum errorCode, Throwable t) {
        super(t);
        this.resultCode = errorCode;
    }

    public ResponseCodeEnum getResultCode() {
        return resultCode;
    }
}

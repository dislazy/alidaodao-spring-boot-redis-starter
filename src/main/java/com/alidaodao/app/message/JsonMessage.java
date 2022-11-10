package com.alidaodao.app.message;

import com.alidaodao.app.exception.ResponseCodeEnum;

import java.io.Serializable;

/**
 * @author jack
 * @since 2022-11-10
 */
public class JsonMessage<T> implements Serializable {

    /**
     * msg
     */
    public String resMsg;
    /**
     * resCode
     */
    private String resCode;
    /**
     * data
     */
    private T data;


    public JsonMessage() {

    }

    public JsonMessage(ResponseCodeEnum resultCodeEnum) {
        this.resCode = resultCodeEnum.getCode();
        this.resMsg = resultCodeEnum.getEnName();
    }

    public JsonMessage(T obj, ResponseCodeEnum resultCodeEnum) {
        this.data = obj;
        this.resCode = resultCodeEnum.getCode();
        this.resMsg = resultCodeEnum.getEnName();
    }

    public JsonMessage(String code, String name) {
        this.resCode = code;
        this.resMsg = name;
    }

    public JsonMessage(T obj, String code, String name) {
        this.data = obj;
        this.resCode = code;
        this.resMsg = name;
    }
}

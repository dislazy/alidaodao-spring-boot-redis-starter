package com.alidaodao.app.web;

import com.alidaodao.app.exception.ResponseCodeEnum;
import com.alidaodao.app.message.JsonMessage;

/**
 * @author jack
 * @since 2022-11-23
 */
public class BaseController {

    public <T> JsonMessage buildJsonResult(T obj) {
        return new JsonMessage(obj, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getCnName());
    }

    public JsonMessage buildJsonResult(){
        return  buildJsonResult(ResponseCodeEnum.SUCCESS);
    }

    public JsonMessage buildJsonResult(ResponseCodeEnum codeEnum){
        return  new JsonMessage(null, codeEnum.getCode(), codeEnum.getCnName());
    }
}

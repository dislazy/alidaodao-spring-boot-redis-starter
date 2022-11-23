package com.alidaodao.app.web;

import com.alidaodao.app.message.JsonMessage;

/**
 * @author jack
 * @since 2022-11-23
 */
public class HelloController extends BaseController{


    /**
     * send message
     * @param ob
     * @return
     */
    public JsonMessage sendMessage(String ob){
        return buildJsonResult(ob);
    }
}

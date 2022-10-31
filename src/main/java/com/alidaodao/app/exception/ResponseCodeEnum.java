package com.alidaodao.app.exception;

import java.io.Serializable;

/**
 * @author jack
 * @since 2022-10-31
 */
public enum ResponseCodeEnum implements Serializable {

    SUCCESS("0", "成功", "Success"),
    FAILED("-1", "未知错误", "Unknown error"),

    // 授权访问类
    UNAUTHORIZED("-1000", "授权失败", "Unauthorized"),
    FORBIDDEN("-1001", "未授权，禁止访问", "Forbidden"),
    ;
    private String code;
    private String cnName;
    private String enName;

    ResponseCodeEnum(String code, String cnName, String enName) {
        this.code = code;
        this.cnName = cnName;
        this.enName = enName;
    }

    public String getCode() {
        return this.code;
    }

    public String getCnName() {
        return this.cnName;
    }

    public String getEnName() {
        return this.enName;
    }

    @Override
    public String toString() {
        return "Code：" + this.getCode() + "，CnMsg：" + this.getEnName() + "，EnMsg：" + this.getCnName();
    }
}

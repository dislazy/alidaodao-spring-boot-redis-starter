package com.alidaodao.app.utils;

import java.util.UUID;

/**
 * @author jack
 * @since 2022-10-02
 */
public class IdGenTools {

    /**
     * 生成UUID
     *
     * @return UUID
     */
    public static String UUID() {
        return UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }

}

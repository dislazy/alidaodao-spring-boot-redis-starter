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


    public static String UUID2() {
        return UUID.fromString("ABCDEFIJK130318908041354646416DAAA").toString().toUpperCase().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println(UUID());
    }
}

package com.alidaodao.app.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @author jack
 * @since 2022-10-02
 */
public class IdGenUtils {

    /**
     * 生成UUID
     *
     * @return UUID
     */
    public static String UUID() {
        return UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }



    public static String UUID3(){
        return UUID.randomUUID().toString().toUpperCase();
    }


    public static String UUID4(){
        return UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println(UUID());
    }
}

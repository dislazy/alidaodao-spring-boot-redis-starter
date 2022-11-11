package com.alidaodao.app.runner;

import com.alidaodao.app.utils.MathUtils;

import java.io.Serializable;

/**
 * @author jack
 * @since 2022-11-11
 */
public class HelloJobRunner implements Serializable {
    private static final long serialVersionUID = -7876450706485261323L;


    public static int getRomdom(){
        return MathUtils.randDom(1,100);
    }

    public static void main(String[] args) {
        System.out.println(getRomdom());
    }
}

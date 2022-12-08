package com.alidaodao.app.utils;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author jack
 * @since 2022-12-08
 */
public class safeUtils implements Serializable {

    /**
     *
     */
    private final static String[] STR_DIGITS = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};


    /**
     * 对象转Integer
     *
     * @param obj
     * @return
     */
    public static Integer getInteger(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!NumberUtils.isCreatable(String.valueOf(obj))){
            return null;
        }
        return Integer.valueOf(obj.toString());
    }

    /**
     * 对象转Long
     *
     * @param obj
     * @return
     */
    public static Long getLong(Object obj) {
        if (obj == null) {
            return null;
        }
        if (NumberUtils.isCreatable(String.valueOf(obj))) {
            return Long.valueOf(obj.toString());
        }
        return null;
    }

    /**
     * 对象转Double
     *
     * @param obj
     * @return
     */
    public static Double getDouble(Object obj) {
        if (obj == null) {
            return null;
        }
        if (NumberUtils.isCreatable(String.valueOf(obj))) {
            return Double.valueOf(obj.toString());
        }
        return null;
    }

    /**
     * 对象转Boolean
     *
     * @param obj
     * @return
     */
    public static Boolean getBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return Boolean.valueOf(obj.toString());
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 转字符串
     *
     * @param obj
     * @return
     */
    public static String getString(Object obj) {
        return obj == null ? null : obj.toString();
    }


    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return STR_DIGITS[iD1] + STR_DIGITS[iD2];
    }

    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    public static String getMd5Code(String strObj) {
        String resultString = null;
        try {
            resultString = strObj;
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest(strObj.getBytes(Charset.defaultCharset())));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }

}

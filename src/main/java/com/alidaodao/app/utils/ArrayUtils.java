package com.alidaodao.app.utils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jack
 * @since 2022-10-19
 */
public class ArrayUtils {

    /**
     * 合并数组
     *
     * @param first
     * @param rest
     * @param <T>
     * @return
     */
    @SafeVarargs
    public static <T> T[] merge(T[] first, T[]... rest) {
        int totalLength = first.length;
        for (T[] array : rest) {
            if (array == null || array.length == 0) {
                continue;
            }
            totalLength += array.length;
        }
        T[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (T[] array : rest) {
            if (array == null || array.length == 0) {
                continue;
            }
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }


    public static void main(String[] args) {

    }
}

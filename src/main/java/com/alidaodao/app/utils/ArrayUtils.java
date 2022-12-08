package com.alidaodao.app.utils;

import java.util.Arrays;
import java.util.List;
import static java.util.Arrays.asList;

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


    /**
     * 使用分隔符分割List
     *
     * @param strList   list
     * @param separator 分隔符 不配置,默认逗号
     * @return 结果
     */
    public static String join(List<String> strList, String... separator) {
        if (strList == null || strList.size() == 0) {
            return "";
        }
        String spt = ",";
        if (separator != null && separator.length > 0) {
            spt = separator[0];
        }
        String result = null;
        for (String str : strList) {
            if (str == null) {
                continue;
            }
            if (result == null) {
                result = str;
            } else {
                result += spt + str;
            }
        }
        return result;
    }


    /**
     * 字符串分割成list
     *
     * @param str   字符串
     * @param regex 分隔正则,默认逗号
     * @return list
     */
    public static List<String> split(String str, String... regex) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        String spt = ",";
        if (regex != null && regex.length > 0) {
            spt = regex[0];
        }
        return asList(str.split(spt));
    }

    /**
     * 数组末尾追加
     *
     * @param objects
     * @param object
     * @return
     */
    public static Object[] append(Object[] objects, Object object) {
        if (objects == null) {
            objects = new Object[]{};
        }
        Object[] newObjects = new Object[objects.length + 1];
        System.arraycopy(objects, 0, newObjects, 0, newObjects.length - 1);
        newObjects[objects.length] = object;
        return newObjects;
    }

    public static String[] append(String[] objects, String object) {
        if (objects == null) {
            objects = new String[]{};
        }
        String[] newObjects = new String[objects.length + 1];
        System.arraycopy(objects, 0, newObjects, 0, newObjects.length - 1);
        newObjects[objects.length] = object;
        return newObjects;
    }

    /**
     * 字符串切割成 Long 数组
     *
     * @param str   字符串
     * @param regex 切割正则，默认逗号
     * @return Long 数组
     */
    public static Long[] splitToLongs(String str, String... regex) {
        List<String> list = split(str, regex);
        if (list == null) {
            return null;
        }
        Long[] longs = new Long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            longs[i] = Long.getLong(list.get(i));
        }
        return longs;
    }

    /**
     * 字符串切割成 Long 数组
     *
     * @param str   字符串
     * @param regex 切割正则，默认逗号
     * @return Long 数组
     */
    public static Integer[] splitToIntegers(String str, String... regex) {
        List<String> list = split(str, regex);
        if (list == null) {
            return null;
        }
        Integer[] integers = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            integers[i] = Integer.parseInt(list.get(i));
        }
        return integers;
    }

    public static void main(String[] args) {

    }
}

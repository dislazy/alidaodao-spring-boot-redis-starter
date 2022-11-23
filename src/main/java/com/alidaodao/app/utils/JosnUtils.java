package com.alidaodao.app.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author jack
 * @since 2022-10-31
 */
public class JosnUtils {

    /**
     * 执行set方法
     *
     * @param o         执行对象
     * @param fieldName 属性
     * @param value     值
     */

    public static void invokeSet(Object o, String fieldName, Object value) {
        Method method = getSetMethod(o.getClass(), fieldName);
        try {
            method.invoke(o, new Object[]{value});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * java反射bean的set方法
     *
     * @param objectClass
     * @param fieldName
     * @return
     */

    @SuppressWarnings("unchecked")

    public static Method getSetMethod(Class objectClass, String fieldName) {
        try {
            Class[] parameterTypes = new Class[1];
            Field field = objectClass.getDeclaredField(fieldName);
            parameterTypes[0] = field.getType();
            StringBuffer sb = new StringBuffer();
            sb.append("set");
            sb.append(fieldName.substring(0, 1).toUpperCase());
            sb.append(fieldName.substring(1));
            return objectClass.getMethod(sb.toString(), parameterTypes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.alidaodao.app.utils;

import com.alidaodao.app.exception.BadRequestException;
import com.alidaodao.app.exception.ResponseCodeEnum;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author jack
 * @since 2022-10-31
 */
public class JosnUtils {
    public static ObjectMapper objectMapper;

    public static String mergeObject(Object... objs) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        String json = null;
        try {
            Map<String, Object> jsonObjectMap = new HashMap<>();
            for (Object obj : objs) {
                if (Objects.nonNull(obj)) {
                    Map<String, Object> jsonMap =  null;
                    if (null != jsonMap) {
                        jsonObjectMap.putAll(jsonMap);
                    }
                }
            }
        } catch (Exception e) {
            throw new BadRequestException(ResponseCodeEnum.FAILED);
        }
        return json;
    }


    /**
     * 执行set方法
     *
     * @param o 执行对象
     * @param fieldName 属性
     * @param value 值
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

            Method method = objectClass.getMethod(sb.toString(), parameterTypes);

            return method;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }
}

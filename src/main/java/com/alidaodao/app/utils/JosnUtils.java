package com.alidaodao.app.utils;

import com.alidaodao.app.exception.BadRequestException;
import com.alidaodao.app.exception.ResponseCodeEnum;

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

}

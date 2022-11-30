package com.alidaodao.app.annonation;

import java.lang.annotation.*;

/**
 * @author jack
 * @since 2022-11-30
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestLimit {

    /**
     * 限制访问的次数，默认不限制
     * @author
     * @since 9/23/21
     * @retuen int
     */
    int count() default Integer.MAX_VALUE;

    /**
     * 时间窗口，单位秒，默认一秒
     * @author
     * @since 9/23/21
     * @retuen int
     */
    int timeWindow() default 1;

}


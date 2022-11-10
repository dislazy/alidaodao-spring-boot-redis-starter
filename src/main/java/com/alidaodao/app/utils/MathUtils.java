package com.alidaodao.app.utils;

import java.math.BigDecimal;

/**
 * @author jack
 * @since 2022-11-10
 */
public class MathUtils {

    /**
     * 获取百分比值Long
     *
     * @param child     分子
     * @param sum       分母
     * @param startNum  最初精确位数
     * @param endNum    最终精确位数
     * @param mulNum    乘以的数
     * @return
     */
    public static BigDecimal percentValue(Long child, Long sum, Integer startNum, Integer endNum, Integer mulNum) {
        return new BigDecimal(child).divide(new BigDecimal(sum),startNum, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(mulNum)).setScale(endNum, BigDecimal.ROUND_HALF_UP);
    }
}

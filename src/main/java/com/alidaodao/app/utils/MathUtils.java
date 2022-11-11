package com.alidaodao.app.utils;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @author jack
 * @since 2022-11-10
 */
public class MathUtils {

    static Random random = new Random();

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


    /**
     * 获取百分比值
     *
     * @param child     分子
     * @param sum       分母
     * @param startNum  最初精确位数
     * @param endNum    最终精确位数
     * @param mulNum    乘以的数
     * @return
     */
    public static BigDecimal percent(Number child, Number sum, Integer startNum, Integer endNum, Integer mulNum) {
        if (child == null || sum == null || sum.longValue() == 0L){
            return new BigDecimal("");
        }
        return new BigDecimal(String.valueOf(child)).divide(new BigDecimal(String.valueOf(sum)),startNum, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(mulNum)).setScale(endNum, BigDecimal.ROUND_HALF_UP);
    }


    /**
     * 根据最大值与最小值随机获取
     *
     * @param min
     * @param max
     * @return
     */
    public static int randDom(int min, int max) {
        return random.nextInt(max) % (max - min + 1) + min;
    }

}

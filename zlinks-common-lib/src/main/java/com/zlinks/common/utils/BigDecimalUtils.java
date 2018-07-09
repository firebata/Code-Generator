package com.zlinks.common.utils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangjh 2016/11/23.
 */
public class BigDecimalUtils {
    /**
     * 除法 默认保留10位小数 并且四舍五入
     *
     * @param divider  除数
     * @param dividend 被除数
     * @return
     */
    public static BigDecimal divide(BigDecimal divider, BigDecimal dividend) {
        return divider.divide(dividend, 10, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal divide(BigDecimal divider, String dividend) {
        return divide(divider, new BigDecimal(dividend));
    }

    public static BigDecimal divide(String divider, String dividend) {
        return divide(new BigDecimal(divider), new BigDecimal(dividend));
    }

    /**
     * 保留两位小数 (四舍五入)
     *
     * @param amount 金额
     * @return
     */
    public static Double setScale(Double amount) {
        if (amount == null) {
            return 0D;
        }
        return Double.valueOf(new BigDecimal(amount).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
    }

    /**
     * 保留两位小数 (四舍五入)
     *
     * @param number 数字
     * @return
     */
    public static String setScale(String number) {
        if (number == null) {
            return "0";
        }
        return String.valueOf(new BigDecimal(number).setScale(4, BigDecimal.ROUND_DOWN).toString());
    }

    /**
     * 金额验证
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式
        Matcher match = pattern.matcher(str);
        if (match.matches() == false) {
            return false;
        } else {
            return true;
        }
    }

}

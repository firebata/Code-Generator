package com.zlinks.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 身份证严格校验工具
 */
public class IDCardValidateUtil {
    private static final String IDCARD_PATTERN = "(^\\d{15}$)|(^\\d{17}([0-9]|X)$)";
    private static final Pattern IDCARD_REG = Pattern.compile(IDCARD_PATTERN);
    private static final int SHORT_IDCARD_LENGTH_15 = 15;
    private static final int MAX_AGE_150 = 150;
    private static final int BIRTH_END_14 = 14;
    private static final int BIRTH_START_6 = 6;
    private static final int MOD_11 = 11;
    private static final int PREFIX_17 = 17;
    private final static Map<String, String> AREA_CODE = new HashMap<String, String>();
    private static final ThreadLocal<SimpleDateFormat> SIMPLE_FORMAT = new ThreadLocal<>();

    private static final char[] CHECK_CODE = {'1', '0', 'x', '9', '8', '7', '6', '5', '4', '3', '2'};

    final static int[] WI = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    /**
     * 设置地区编码
     */
    static {
        AREA_CODE.put("11", "北京");
        AREA_CODE.put("12", "天津");
        AREA_CODE.put("13", "河北");
        AREA_CODE.put("14", "山西");
        AREA_CODE.put("15", "内蒙古");
        AREA_CODE.put("21", "辽宁");
        AREA_CODE.put("22", "吉林");
        AREA_CODE.put("23", "黑龙江");
        AREA_CODE.put("31", "上海");
        AREA_CODE.put("32", "江苏");
        AREA_CODE.put("33", "浙江");
        AREA_CODE.put("34", "安徽");
        AREA_CODE.put("35", "福建");
        AREA_CODE.put("36", "江西");
        AREA_CODE.put("37", "山东");
        AREA_CODE.put("41", "河南");
        AREA_CODE.put("42", "湖北");
        AREA_CODE.put("43", "湖南");
        AREA_CODE.put("44", "广东");
        AREA_CODE.put("45", "广西");
        AREA_CODE.put("46", "海南");
        AREA_CODE.put("50", "重庆");
        AREA_CODE.put("51", "四川");
        AREA_CODE.put("52", "贵州");
        AREA_CODE.put("53", "云南");
        AREA_CODE.put("54", "西藏");
        AREA_CODE.put("61", "陕西");
        AREA_CODE.put("62", "甘肃");
        AREA_CODE.put("63", "青海");
        AREA_CODE.put("64", "宁夏");
        AREA_CODE.put("65", "新疆");
        AREA_CODE.put("71", "台湾");
        AREA_CODE.put("81", "香港");
        AREA_CODE.put("82", "澳门");
        AREA_CODE.put("91", "国外");
    }

    /**
     * 获取SimpleDateFormat对象，SimpleDateFormat不是线程安全的
     *
     * @return
     */
    public static SimpleDateFormat getDateFormat() {
        SimpleDateFormat dateFormat = SIMPLE_FORMAT.get();
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat("yyyyMMdd");
            SIMPLE_FORMAT.set(dateFormat);
        }
        return dateFormat;
    }

    /**
     * 身份证号码验证 1、号码的结构 公民身份号码是特征组合码，由十七位数字本体码和一位校验码组成。排列顺序从左至右依次为：六位数字地址码，
     * 八位数字出生日期码，三位数字顺序码和一位数字校验码。 2、地址码(前六位数）
     * 表示编码对象常住户口所在县(市、旗、区)的行政区划代码，按GB/T2260的规定执行。 3、出生日期码（第七位至十四位）
     * 表示编码对象出生的年、月、日，按GB/T7408的规定执行，年、月、日代码之间不用分隔符。 4、顺序码（第十五位至十七位）
     * 表示在同一地址码所标识的区域范围内，对同年、同月、同日出生的人编定的顺序号， 顺序码的奇数分配给男性，偶数分配给女性。 5、校验码（第十八位数）
     * （1）十七位数字本体码加权求和公式 S = Sum(Ai * Wi), i = 0, ... , 16 ，先对前17位数字的权求和
     * Ai:表示第i位置上的身份证号码数字值 Wi:表示第i位置上的加权因子 Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4
     * 2 （2）计算模 Y = mod(S, 11) （3）通过模得到对应的校验码 Y: 0 1 2 3 4 5 6 7 8 9 10 校验码: 1 0
     * X 9 8 7 6 5 4 3 2
     * <p/>
     * java没有tuple类型，麻烦，只能用对象数组， 第一个为Boolean, 第二个为String
     * result[0]是否校验通过，result[1]校验不通过的失败信息
     *
     * @param idCard 身份证
     * @return
     */
    public static Object[] idCardValidate(String idCard) {
        Object[] result = new Object[2];
        result[0] = Boolean.TRUE;
        //先用正则匹配
        Boolean isValid = checkByRegEx(idCard, result);
        if (!isValid) {
            return result;
        }
        //截取前17位，如果是15位，在78位插入19后再截取
        String innerIDCard = subIdCard(idCard, isValid);
        //生日校验
        isValid = checkBirthDay(innerIDCard, result, isValid);
        if (!isValid) {
            return result;
        }
        //地区校验，只校验第一级地区码
        isValid = checkAreaCode(innerIDCard, result, isValid);
        if (!isValid) {
            return result;
        }
        //校验校验码
        isValid = checkCheckCode(idCard, result, isValid);
        return result;
    }

    /**
     * 不需要校验信息的校验
     *
     * @param idCard idCard信息
     * @return
     */
    public static boolean isIdCardValidate(String idCard) {
        Object[] result = idCardValidate(idCard);
        return (Boolean) result[0];
    }

    private static Boolean checkCheckCode(String idCard, Object[] result, Boolean isValid) {
        if (idCard != null && idCard.length() <= 15) return isValid;
        if (isValid) {
            int sumAiWi = 0;

            for (int i = 0; i < PREFIX_17; i++) {
                sumAiWi += (0 + idCard.charAt(i) - '0') * WI[i];
            }
            int modValue = sumAiWi % MOD_11;
            //char lastChar = idCard.substring(17, idCard.length()).toLowerCase().charAt(0);
            /*CHECK_CODE[modValue] != lastChar*/
            if (!idCard.substring(idCard.length() - 1).equalsIgnoreCase(String.valueOf(CHECK_CODE[modValue]))) {
                result[0] = Boolean.FALSE;
                result[1] = "身份证验证码无效，不是合法的身份证号码";
            }
        }
        return (Boolean) result[0];
    }

    private static Boolean checkAreaCode(String idCard, Object[] result, Boolean isValid) {
        if (isValid) {
            if (AREA_CODE.get(idCard.substring(0, 2)) == null) {
                result[0] = Boolean.FALSE;
                result[1] = "身份证地区编码错误。";
            }
        }
        return (Boolean) result[0];
    }

    private static Boolean checkBirthDay(String idCard, Object[] result, Boolean isValid) {
        if (isValid) {
            String birthDay = idCard.substring(BIRTH_START_6, BIRTH_END_14);
            try {
                Calendar nowCal = Calendar.getInstance();
                Date birthDate = getDateFormat().parse(birthDay);
                Calendar birthCal = Calendar.getInstance();
                birthCal.setTime(birthDate);
                // 身份证如果是19900007会被parse成19891207,所以得判断是否格式化后字符串不同
                if (!birthDay.equals(getDateFormat().format(birthDate))
                        || nowCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR) > MAX_AGE_150
                        || (nowCal.getTimeInMillis() - birthCal.getTimeInMillis() < 0)) {
                    result[0] = Boolean.FALSE;
                    result[1] = "身份证生日不在有效范围。";
                }
            } catch (ParseException e) {
                result[0] = Boolean.FALSE;
                result[1] = "身份证生日无效。";
            }
        }
        return (Boolean) result[0];
    }

    private static String subIdCard(String idCard, Boolean isValid) {
        if (isValid) {
            if (idCard.length() == SHORT_IDCARD_LENGTH_15) {
                return idCard.substring(0, BIRTH_START_6) + "19" + idCard.substring(BIRTH_START_6, SHORT_IDCARD_LENGTH_15);
            } else {
                return idCard.substring(0, PREFIX_17);
            }
        }
        return idCard;
    }

    private static Boolean checkByRegEx(String idCard, Object[] result) {
        if (!isIDCard(idCard)) {
            result[0] = Boolean.FALSE;
            result[1] = "身份证号码长度应该为15位或18位, 15位号码都应为数字 , 18位号码除最后一位可以使x外，都应为数字.";
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 身份证验证，判断是否15位数字或者17位数字+1位校验码
     *
     * @param idCard idCard
     * @return
     */
    public static boolean isIDCard(String idCard) {
        if (isEmpty(idCard)) {
            return false;
        }
        boolean isIdCard = IDCARD_REG.matcher(idCard).matches();
        return isIdCard;
    }

    private static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }
}
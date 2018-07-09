package com.zlinks.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 参数校验工具类
 * Created by bruce on 2017/6/5.
 */

public class ValidateParamUtils {
    private final Logger logger = LoggerFactory.getLogger(ValidateParamUtils.class);
    //邮件正则验证
    private final static String EMAIL_REG = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
    //手机号正则验证
    private final static String INTER_MOBILE_REG = "(?:\\(?[0\\+]?\\d{1,3}\\)?)[\\s-]?(?:0|\\d{1,4})[\\s-]?(?:(?:13\\d{9})|(?:\\d{7,8}))";

    /**
     * 验证邮箱格式
     *
     * @param email
     * @return true 验证成功 false 验证失败
     */
    public static boolean validateEmailFormat(String email) {
        Pattern p = Pattern.compile(EMAIL_REG);
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 验证国际手机号格式
     *
     * @param mobile
     * @return true 验证成功 false 验证失败
     */
    public static boolean validateInterMobileFormat(String mobile) {
//        String mobileStr = mobile.trim();
//        Pattern p = Pattern.compile(INTER_MOBILE_REG);
//        Matcher m = p.matcher(mobileStr);
//        if (!m.matches()) {
//            return false;
//        }
        return true;
    }


}

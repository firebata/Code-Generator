package com.zlinks.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zhangjh on 2017/11/3.
 */
public class MD5Utils {
    private final static Logger log = LoggerFactory.getLogger(MD5Utils.class);

    public static String encript(String plainText) {
        String result = null;
        //首先判断是否为空
        if (StringUtils.isBlank(plainText)) {
            return null;
        }
        try {
            //首先进行实例化和初始化
            MessageDigest md = MessageDigest.getInstance("MD5");
            //得到一个操作系统默认的字节编码格式的字节数组
            byte[] btInput = plainText.getBytes();
            //对得到的字节数组进行处理
            md.update(btInput);
            //进行哈希计算并返回结果
            byte[] btResult = md.digest();
            //进行哈希计算后得到的数据的长度
            StringBuffer sb = new StringBuffer();
            for (byte b : btResult) {
                int bt = b & 0xff;
                if (bt < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(bt));
            }
            result = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
        }
        return result.toUpperCase();
    }


    //public static void main(String[] args) {
      //  System.out.println("encript:" + encript("asdfsdfd"));
    //}
}

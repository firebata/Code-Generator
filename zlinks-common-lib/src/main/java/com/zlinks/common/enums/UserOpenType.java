package com.zlinks.common.enums;

import com.alibaba.fastjson.JSON;

/**
 * 用户登录类型
 */
public enum UserOpenType {

    ALL("ALL"), GUEST("GUEST"), TWITTER("TWITTER"), FACEBOOK("FACEBOOK"), GOOGLE("GOOGLE"), APPLE("APPLE"), zlinks("zlinks"), DEVICE("DEVICE"), OTHERS("OTHERS");

    UserOpenType(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }

    public static void main(String[] args) {
        System.out.println(ALL);
    }
}

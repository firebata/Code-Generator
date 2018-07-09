package com.zlinks.common.enums;

/**
 * Copyright (C), 2018-2018, BBG
 * FileName: BanType
 * Author: Lyle
 * Date: 2018/5/8 18:51
 * Description:封禁/解封类型
 */
public enum UserBanType {
    IP("IP"),           //根据ip封禁/解封
    DEVICE("DEVICE"),   //根据设备号封禁/解封
    USERID("USERID"), //根据账号封禁/解封
    ADID("ADID");      //根据广告ID封禁/解封

    private String value;

    UserBanType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

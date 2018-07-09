package com.zlinks.common.enums;

/**
 * Copyright (C), 2018-2018, BBG
 * FileName: VerifyCodeUseageType
 * Author: zhangjh
 * Date: 2018/5/19 09:04
 * Description: 验证码用途
 */
public enum VerifyCodeUseageType {
    BIND("注册"), PWD("找回密码");
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    VerifyCodeUseageType(String value) {
        this.value = value;
    }

}

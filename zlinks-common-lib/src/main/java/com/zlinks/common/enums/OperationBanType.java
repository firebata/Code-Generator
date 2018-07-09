package com.zlinks.common.enums;

/**
 * Copyright (C), 2018-2018, BBG
 * FileName: OperationBanType
 * Author: Lyle
 * Date: 2018/5/8 19:02
 * Description:封禁/解封
 */
public enum OperationBanType {

    BAN("BAN"),     //封禁
    UNBAN("UNBAN"); //解封

    private String value;

    OperationBanType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

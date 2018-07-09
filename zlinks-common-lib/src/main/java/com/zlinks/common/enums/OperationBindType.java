package com.zlinks.common.enums;

/**
 * Copyright (C), 2018-2018, BBG
 * FileName: OperationBindType
 * Author: Lyle
 * Date: 2018/5/18 14:34
 * Description:绑定/解绑
 */
public enum OperationBindType {

    BIND("BIND"),   //绑定
    UNBIND("UNBIND");   //解绑

    private String value;

    OperationBindType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

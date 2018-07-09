package com.zlinks.common.helper;

import com.zlinks.common.constants.CommonConstant;

import java.util.UUID;

/**
 * Copyright (C), 2018-2018, BBG
 * FileName: CommonHelper
 * Author:   zhangjh
 * Date:     2018/5/4 13:59
 * Description:
 */
public enum CommonHelper {
    INSTANCE;

    public String genUnionId() {
        String unionId = UUID.randomUUID().toString().replaceAll(CommonConstant.MINUS.getValue(), CommonConstant.EMPTY.getValue());
        return unionId;
    }
}

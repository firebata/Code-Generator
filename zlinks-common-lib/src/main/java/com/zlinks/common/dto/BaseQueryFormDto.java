package com.zlinks.common.dto;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.dto.pager.DataTablesInfo;

/**
 * Copyright (C), 2017-2018, BBG
 * FileName: BaseQueryFormDto
 * Author:   zhangjh
 * Date:     2018/6/7 14:14
 * Description:
 */
public class BaseQueryFormDto {
    /**
     *
     */
    private String startTime;
    /**
     *
     */
    private String endTime;

    private DataTablesInfo dataTablesInfo;


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public DataTablesInfo getDataTablesInfo() {
        return dataTablesInfo;
    }

    public void setDataTablesInfo(DataTablesInfo dataTablesInfo) {
        this.dataTablesInfo = dataTablesInfo;
    }

    @Override
    public String toString() {
        return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }
}

package com.zlinks.common;

import com.zlinks.common.dto.pager.DataTablesInfo;

/**
 * Copyright (C), 2017-2018, BBG
 * FileName: BaseQueryForm
 * Author:   zhangjh
 * Date:     2018/6/7 10:39
 * Description: 基础查询form
 */
public class BaseQueryForm {

    private String starDate;
    private String endDate;

    private DataTablesInfo dataTablesInfo;

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public DataTablesInfo getDataTablesInfo() {
        return dataTablesInfo;
    }

    public void setDataTablesInfo(DataTablesInfo dataTablesInfo) {
        this.dataTablesInfo = dataTablesInfo;
    }
}

package com.zlinks.common.dto.pager;

import com.alibaba.fastjson.JSON;

/**
 * Copyright (C), 2017-2018, BBG
 * FileName: DataTablesInfo
 * Author:   zhangjh
 * Date:     2018/6/6 20:14
 * Description: 前端表格插件信息
 */
public class DataTablesInfo {
    /**
     * 当前页的开始记录数下标
     */
    private int start;
    /**
     * 一页的长度
     */
    private int length;
    /**
     * 点击次数
     */
    private int draw;
    /**
     * 排序的列
     */
    private String orderColumn;
    /**
     * 升序还是倒序
     */
    private String orderDir;
    /**
     * 查询信息
     */
    private String searchValue;

    /**
     * limit SQL语句：limit begin,length
     */
    private String limitAfter;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrderDir() {
        return orderDir;
    }

    public void setOrderDir(String orderDir) {
        this.orderDir = orderDir;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getLimitAfter() {
        return limitAfter;
    }

    public void setLimitAfter(String limitAfter) {
        this.limitAfter = limitAfter;
    }

    @Override
    public String toString() {
        return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }
}

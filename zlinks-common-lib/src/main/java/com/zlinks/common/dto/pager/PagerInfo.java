package com.zlinks.common.dto.pager;

import com.alibaba.fastjson.annotation.JSONField;
import com.zlinks.common.domain.BaseDomain;

import java.util.Date;

/**
 * Copyright (C), 2017-2018, BBG
 * FileName: PagerInfo
 * Author:   zhangjh
 * Date:     2018/6/6 20:15
 * Description: 分页信息
 */
public class PagerInfo extends BaseDomain {
    /**
     * 开始记录
     */
    private Integer start = 0;
    /**
     * 每页记录数
     */
    private Integer limit = 30;
    /**
     * 页面请求次数
     */
    private Integer draw;

    /**
     * 记录数：用于数据查询时保存过滤条件查询出的记录数
     */
    private Integer filterCounts;

    /**
     * 总页数
     */
    private Integer pageCounts;

    /**
     * 总记录数
     */
    private Integer resultCounts;


    private Integer pageNo;


    private Integer pageSize;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date endTime;


    public PagerInfo() {
    }

    public PagerInfo(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getFilterCounts() {
        return filterCounts;
    }

    public void setFilterCounts(Integer filterCounts) {
        this.filterCounts = filterCounts;
    }

    public Integer getPageCounts() {
        return pageCounts;
    }

    public void setPageCounts(Integer pageCounts) {
        this.pageCounts = pageCounts;
    }

    public Integer getResultCounts() {
        return resultCounts;
    }

    public void setResultCounts(Integer resultCounts) {
        this.resultCounts = resultCounts;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

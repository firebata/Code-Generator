package com.zlinks.common.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhangjh on 2017/10/10.
 * dto entity
 */
public class BaseDto implements Serializable {
    /**
     *
     */
    public Long id;

    /**
     *
     */
    protected Date createdTime;

    /**
     *
     */
    protected Date updateTime;

    /**
     *
     */
    protected Integer pageNo;

    /**
     *
     */
    protected Integer pageSize;

    /**
     *
     */
    protected String orderBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}

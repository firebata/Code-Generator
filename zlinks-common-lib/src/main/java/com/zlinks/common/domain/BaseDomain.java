package com.zlinks.common.domain;

import com.zlinks.common.enums.Whether;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhanjgh on 2017/10/13.
 */
public class BaseDomain implements Serializable {
    /**
     *
     */
    protected Long id;

    /**
     * 新建时间
     */
    protected Date createdTime;

    /**
     * 更新时间
     */
    protected Date updateTime;

    /**
     * 是否逻辑删除
     */
    protected Whether deleteFlag = Whether.NO;

    /**
     *
     */
    protected Integer version = 0;


    public BaseDomain() {
    }

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

    public Whether getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Whether deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}

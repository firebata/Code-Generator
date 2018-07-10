package com.zlinks.domain;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.dto.pager.PagerInfo;
/**
* Copyright (C), 2017-2020, cn.zlinks
* FileName: AuthElement
* Author:   zhangjh
* Date:     2018-7-10 19:53:10
* Description: 表名：auth_element,描述：
*/
public class AuthElement extends PagerInfo  {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Long elementId;
	/**
	 * 
	 */
	private Long authId;

	/**
	 * 获取
	 */
	public Long getElementId() {
		return this.elementId;
	}

	/**
	 * 设置
	 */
	public void setElementId(Long elementId) {
		this.elementId = elementId;
	}

	/**
	 * 获取
	 */
	public Long getAuthId() {
		return this.authId;
	}

	/**
	 * 设置
	 */
	public void setAuthId(Long authId) {
		this.authId = authId;
	}

    @Override
    public String toString() {
    	return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }
}

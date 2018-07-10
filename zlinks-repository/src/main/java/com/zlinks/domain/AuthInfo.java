package com.zlinks.domain;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.dto.pager.PagerInfo;
/**
* Copyright (C), 2017-2020, cn.zlinks
* FileName: AuthInfo
* Author:   zhangjh
* Date:     2018-7-10 19:31:43
* Description: 表名：auth_info,描述：
*/
public class AuthInfo extends PagerInfo  {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Long id;
	/**
	 * 
	 */
	private Long authId;
	/**
	 * 
	 */
	private Long parentAuthId;
	/**
	 * MENU:菜单；ELEMENT:元素
	 */
	private String authType;

	/**
	 * 获取
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * 设置
	 */
	public void setId(Long id) {
		this.id = id;
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

	/**
	 * 获取
	 */
	public Long getParentAuthId() {
		return this.parentAuthId;
	}

	/**
	 * 设置
	 */
	public void setParentAuthId(Long parentAuthId) {
		this.parentAuthId = parentAuthId;
	}

	/**
	 * 获取MENU:菜单；ELEMENT:元素
	 */
	public String getAuthType() {
		return this.authType;
	}

	/**
	 * 设置MENU:菜单；ELEMENT:元素
	 */
	public void setAuthType(String authType) {
		this.authType = authType;
	}

    @Override
    public String toString() {
    	return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }
}

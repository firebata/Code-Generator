package com.zlinks.domain;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.dto.pager.PagerInfo;
/**
* Copyright (C), 2017-2020, cn.zlinks
* FileName: RoleAuth
* Author:   zhangjh
* Date:     2018-7-10 19:31:43
* Description: 表名：role_auth,描述：
*/
public class RoleAuth extends PagerInfo  {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Long roleId;
	/**
	 * 
	 */
	private Long authId;

	/**
	 * 获取
	 */
	public Long getRoleId() {
		return this.roleId;
	}

	/**
	 * 设置
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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

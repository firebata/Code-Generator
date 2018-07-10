package com.zlinks.domain;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.dto.pager.PagerInfo;
/**
* Copyright (C), 2017-2020, cn.zlinks
* FileName: RoleInfo
* Author:   zhangjh
* Date:     2018-7-10 19:31:43
* Description: 表名：role_info,描述：
*/
public class RoleInfo extends PagerInfo  {
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
	private Long roleId;
	/**
	 * 
	 */
	private String roleName;

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
	public String getRoleName() {
		return this.roleName;
	}

	/**
	 * 设置
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

    @Override
    public String toString() {
    	return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }
}

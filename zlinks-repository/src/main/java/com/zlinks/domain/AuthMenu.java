package com.zlinks.domain;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.dto.pager.PagerInfo;
/**
* Copyright (C), 2017-2020, cn.zlinks
* FileName: AuthMenu
* Author:   zhangjh
* Date:     2018-7-10 19:31:43
* Description: 表名：auth_menu,描述：
*/
public class AuthMenu extends PagerInfo  {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Long menuId;
	/**
	 * 
	 */
	private Long authId;

	/**
	 * 获取
	 */
	public Long getMenuId() {
		return this.menuId;
	}

	/**
	 * 设置
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
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

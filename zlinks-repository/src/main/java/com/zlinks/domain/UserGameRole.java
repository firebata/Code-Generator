package com.zlinks.domain;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.dto.pager.PagerInfo;
/**
* Copyright (C), 2017-2020, cn.zlinks
* FileName: UserGameRole
* Author:   zhangjh
* Date:     2018-7-10 19:53:10
* Description: 表名：user_game_role,描述：
*/
public class UserGameRole extends PagerInfo  {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Long gameId;
	/**
	 * 
	 */
	private Long roleId;

	/**
	 * 获取
	 */
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * 设置
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 获取
	 */
	public Long getGameId() {
		return this.gameId;
	}

	/**
	 * 设置
	 */
	public void setGameId(Long gameId) {
		this.gameId = gameId;
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

    @Override
    public String toString() {
    	return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }
}

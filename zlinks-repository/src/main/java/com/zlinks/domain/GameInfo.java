package com.zlinks.domain;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.dto.pager.PagerInfo;
/**
* Copyright (C), 2017-2020, cn.zlinks
* FileName: GameInfo
* Author:   zhangjh
* Date:     2018-7-10 19:31:43
* Description: 表名：game_info,描述：
*/
public class GameInfo extends PagerInfo  {
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
	private Long gameId;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String nameZh;

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
	public String getName() {
		return this.name;
	}

	/**
	 * 设置
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取
	 */
	public String getNameZh() {
		return this.nameZh;
	}

	/**
	 * 设置
	 */
	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

    @Override
    public String toString() {
    	return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }
}

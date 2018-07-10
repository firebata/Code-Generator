package com.zlinks.domain;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.dto.pager.PagerInfo;
/**
* Copyright (C), 2017-2020, cn.zlinks
* FileName: Menu
* Author:   zhangjh
* Date:     2018-7-10 19:53:10
* Description: 表名：menu,描述：
*/
public class Menu extends PagerInfo  {
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
	private Long menuId;
	/**
	 * 
	 */
	private Long parentMenuId;
	/**
	 * 
	 */
	private String menuName;
	/**
	 * 
	 */
	private String menuUriFrontend;
	/**
	 * 
	 */
	private String menuUriBackend;
	/**
	 * 
	 */
	private Integer sortNo;
	/**
	 * 
	 */
	private Integer levelId;

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
	public Long getParentMenuId() {
		return this.parentMenuId;
	}

	/**
	 * 设置
	 */
	public void setParentMenuId(Long parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	/**
	 * 获取
	 */
	public String getMenuName() {
		return this.menuName;
	}

	/**
	 * 设置
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * 获取
	 */
	public String getMenuUriFrontend() {
		return this.menuUriFrontend;
	}

	/**
	 * 设置
	 */
	public void setMenuUriFrontend(String menuUriFrontend) {
		this.menuUriFrontend = menuUriFrontend;
	}

	/**
	 * 获取
	 */
	public String getMenuUriBackend() {
		return this.menuUriBackend;
	}

	/**
	 * 设置
	 */
	public void setMenuUriBackend(String menuUriBackend) {
		this.menuUriBackend = menuUriBackend;
	}

	/**
	 * 获取
	 */
	public Integer getSortNo() {
		return this.sortNo;
	}

	/**
	 * 设置
	 */
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	/**
	 * 获取
	 */
	public Integer getLevelId() {
		return this.levelId;
	}

	/**
	 * 设置
	 */
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

    @Override
    public String toString() {
    	return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }
}

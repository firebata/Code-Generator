package com.zlinks.domain;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.dto.pager.PagerInfo;
/**
* Copyright (C), 2017-2020, cn.zlinks
* FileName: Element
* Author:   zhangjh
* Date:     2018-7-10 19:53:10
* Description: 表名：element,描述：
*/
public class Element extends PagerInfo  {
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
	private Long elementId;
	/**
	 * 
	 */
	private Long parentElementId;
	/**
	 * 
	 */
	private String elementName;
	/**
	 * 
	 */
	private String elementUriFrontend;
	/**
	 * 
	 */
	private String elementUriBackend;
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
	public Long getParentElementId() {
		return this.parentElementId;
	}

	/**
	 * 设置
	 */
	public void setParentElementId(Long parentElementId) {
		this.parentElementId = parentElementId;
	}

	/**
	 * 获取
	 */
	public String getElementName() {
		return this.elementName;
	}

	/**
	 * 设置
	 */
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	/**
	 * 获取
	 */
	public String getElementUriFrontend() {
		return this.elementUriFrontend;
	}

	/**
	 * 设置
	 */
	public void setElementUriFrontend(String elementUriFrontend) {
		this.elementUriFrontend = elementUriFrontend;
	}

	/**
	 * 获取
	 */
	public String getElementUriBackend() {
		return this.elementUriBackend;
	}

	/**
	 * 设置
	 */
	public void setElementUriBackend(String elementUriBackend) {
		this.elementUriBackend = elementUriBackend;
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

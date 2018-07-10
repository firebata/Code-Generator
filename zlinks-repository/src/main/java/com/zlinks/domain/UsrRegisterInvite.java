package com.zlinks.domain;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.dto.pager.PagerInfo;
import java.util.Date;
/**
* Copyright (C), 2017-2020, cn.zlinks
* FileName: UsrRegisterInvite
* Author:   zhangjh
* Date:     2018-7-10 19:53:10
* Description: 表名：usr_register_invite,描述：
*/
public class UsrRegisterInvite extends PagerInfo  {
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
	private String email;
	/**
	 * 
	 */
	private String mobile;
	/**
	 * 
	 */
	private String url;
	/**
	 * YES：已点击；NO：未点击
	 */
	private String isClick;
	/**
	 * 
	 */
	private Date lastTime;
	/**
	 * 
	 */
	private String isValid;
	/**
	 * 
	 */
	private Long operator;
	/**
	 * 
	 */
	private String urlMd5;
	/**
	 * 游戏id，用“-”连接
	 */
	private String games;
	/**
	 * 
	 */
	private String password;

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
	public String getEmail() {
		return this.email;
	}

	/**
	 * 设置
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取
	 */
	public String getMobile() {
		return this.mobile;
	}

	/**
	 * 设置
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * 设置
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取YES：已点击；NO：未点击
	 */
	public String getIsClick() {
		return this.isClick;
	}

	/**
	 * 设置YES：已点击；NO：未点击
	 */
	public void setIsClick(String isClick) {
		this.isClick = isClick;
	}

	/**
	 * 获取
	 */
	public Date getLastTime() {
		return this.lastTime;
	}

	/**
	 * 设置
	 */
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	/**
	 * 获取
	 */
	public String getIsValid() {
		return this.isValid;
	}

	/**
	 * 设置
	 */
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	/**
	 * 获取
	 */
	public Long getOperator() {
		return this.operator;
	}

	/**
	 * 设置
	 */
	public void setOperator(Long operator) {
		this.operator = operator;
	}

	/**
	 * 获取
	 */
	public String getUrlMd5() {
		return this.urlMd5;
	}

	/**
	 * 设置
	 */
	public void setUrlMd5(String urlMd5) {
		this.urlMd5 = urlMd5;
	}

	/**
	 * 获取游戏id，用“-”连接
	 */
	public String getGames() {
		return this.games;
	}

	/**
	 * 设置游戏id，用“-”连接
	 */
	public void setGames(String games) {
		this.games = games;
	}

	/**
	 * 获取
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * 设置
	 */
	public void setPassword(String password) {
		this.password = password;
	}

    @Override
    public String toString() {
    	return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }
}

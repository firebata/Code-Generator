package com.zlinks.domain;

import com.alibaba.fastjson.JSON;
import com.zlinks.common.dto.pager.PagerInfo;
/**
* Copyright (C), 2017-2020, cn.zlinks
* FileName: UserInfo
* Author:   zhangjh
* Date:     2018-7-10 19:31:43
* Description: 表名：user_info,描述：
*/
public class UserInfo extends PagerInfo  {
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
	private Long userId;
	/**
	 * 
	 */
	private String account;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private String birth;
	/**
	 * 
	 */
	private String sex;
	/**
	 * 
	 */
	private String mobile;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String nickName;
	/**
	 * 
	 */
	private String adminFlag;
	/**
	 * 
	 */
	private String uid;

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
	public String getAccount() {
		return this.account;
	}

	/**
	 * 设置
	 */
	public void setAccount(String account) {
		this.account = account;
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

	/**
	 * 获取
	 */
	public String getBirth() {
		return this.birth;
	}

	/**
	 * 设置
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}

	/**
	 * 获取
	 */
	public String getSex() {
		return this.sex;
	}

	/**
	 * 设置
	 */
	public void setSex(String sex) {
		this.sex = sex;
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
	public String getNickName() {
		return this.nickName;
	}

	/**
	 * 设置
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 获取
	 */
	public String getAdminFlag() {
		return this.adminFlag;
	}

	/**
	 * 设置
	 */
	public void setAdminFlag(String adminFlag) {
		this.adminFlag = adminFlag;
	}

	/**
	 * 获取
	 */
	public String getUid() {
		return this.uid;
	}

	/**
	 * 设置
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

    @Override
    public String toString() {
    	return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }
}

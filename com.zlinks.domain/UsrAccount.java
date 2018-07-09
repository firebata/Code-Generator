package com.zlinks.com.zlinks.domain;

import com.hpxs.base.BaseEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.math.BigInteger;
import java.util.Date;

/**
 * 实体bean
 * <p>
 * 表名：usr_account
 * <p>
 * 描述：
 */
public class UsrAccount extends BaseEntity implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private BigInteger id;
	/**
	 * 创建时间
	 */
	private Date createdTime;
	/**
	 * 是否逻辑删除 (是:YES,否:NO)
	 */
	private String deleteFlag;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 
	 */
	private BigInteger version;
	/**
	 * 玩家账号
	 */
	private String account;
	/**
	 * 设备号
	 */
	private String devUniqueId;
	/**
	 * 注册邮箱
	 */
	private String email;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 玩家昵称
	 */
	private String nickName;
	/**
	 * 登录类型
	 */
	private String openType;
	/**
	 * 账号密码
	 */
	private String password;
	/**
	 * 状态
	 */
	private Integer state;
	/**
	 * 唯一用户编号
	 */
	private String uid;

	/**
	 * 获取
	 */
	public BigInteger getId() {
		return this.id;
	}

	/**
	 * 设置
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * 获取创建时间
	 */
	public Date getCreatedTime() {
		return this.createdTime;
	}

	/**
	 * 设置创建时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * 获取是否逻辑删除 (是:YES,否:NO)
	 */
	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	/**
	 * 设置是否逻辑删除 (是:YES,否:NO)
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * 获取修改时间
	 */
	public Date getUpdateTime() {
		return this.updateTime;
	}

	/**
	 * 设置修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取
	 */
	public BigInteger getVersion() {
		return this.version;
	}

	/**
	 * 设置
	 */
	public void setVersion(BigInteger version) {
		this.version = version;
	}

	/**
	 * 获取玩家账号
	 */
	public String getAccount() {
		return this.account;
	}

	/**
	 * 设置玩家账号
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * 获取设备号
	 */
	public String getDevUniqueId() {
		return this.devUniqueId;
	}

	/**
	 * 设置设备号
	 */
	public void setDevUniqueId(String devUniqueId) {
		this.devUniqueId = devUniqueId;
	}

	/**
	 * 获取注册邮箱
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * 设置注册邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取手机号码
	 */
	public String getMobile() {
		return this.mobile;
	}

	/**
	 * 设置手机号码
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取玩家昵称
	 */
	public String getNickName() {
		return this.nickName;
	}

	/**
	 * 设置玩家昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 获取登录类型
	 */
	public String getOpenType() {
		return this.openType;
	}

	/**
	 * 设置登录类型
	 */
	public void setOpenType(String openType) {
		this.openType = openType;
	}

	/**
	 * 获取账号密码
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * 设置账号密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取状态
	 */
	public Integer getState() {
		return this.state;
	}

	/**
	 * 设置状态
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * 获取唯一用户编号
	 */
	public String getUid() {
		return this.uid;
	}

	/**
	 * 设置唯一用户编号
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

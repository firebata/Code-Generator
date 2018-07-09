package com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/;

import com.hpxs.base.BaseEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.math.BigInteger;
import java.util.Date;

/**
 * 实体bean
 * <p>
 * 表名：log_reset_password
 * <p>
 * 描述：
 */
public class LogResetPassword extends BaseEntity implements Serializable {
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
	 * 
	 */
	private String account;
	/**
	 * 
	 */
	private String devUniqueId;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String ip;
	/**
	 * 
	 */
	private String newPassword;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 旧密码
	 */
	private String oldPassword;
	/**
	 * 类型(手机找回:MOBILE,邮箱找回:EMAIL,修改密码:UPDATE)
	 */
	private String resetType;

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
	public String getDevUniqueId() {
		return this.devUniqueId;
	}

	/**
	 * 设置
	 */
	public void setDevUniqueId(String devUniqueId) {
		this.devUniqueId = devUniqueId;
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
	public String getIp() {
		return this.ip;
	}

	/**
	 * 设置
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 获取
	 */
	public String getNewPassword() {
		return this.newPassword;
	}

	/**
	 * 设置
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * 获取手机
	 */
	public String getMobile() {
		return this.mobile;
	}

	/**
	 * 设置手机
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取旧密码
	 */
	public String getOldPassword() {
		return this.oldPassword;
	}

	/**
	 * 设置旧密码
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * 获取类型(手机找回:MOBILE,邮箱找回:EMAIL,修改密码:UPDATE)
	 */
	public String getResetType() {
		return this.resetType;
	}

	/**
	 * 设置类型(手机找回:MOBILE,邮箱找回:EMAIL,修改密码:UPDATE)
	 */
	public void setResetType(String resetType) {
		this.resetType = resetType;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

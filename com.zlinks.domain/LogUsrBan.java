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
 * 表名：log_usr_ban
 * <p>
 * 描述：
 */
public class LogUsrBan extends BaseEntity implements Serializable {
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
	 * 封禁模块
	 */
	private String module;
	/**
	 * 账号类型
	 */
	private String openType;
	/**
	 * 操作人
	 */
	private String operator;
	/**
	 * 封禁条件
	 */
	private String parameter;
	/**
	 * 封禁状态
	 */
	private String status;
	/**
	 * 封禁类型
	 */
	private String type;

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
	 * 获取封禁模块
	 */
	public String getModule() {
		return this.module;
	}

	/**
	 * 设置封禁模块
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * 获取账号类型
	 */
	public String getOpenType() {
		return this.openType;
	}

	/**
	 * 设置账号类型
	 */
	public void setOpenType(String openType) {
		this.openType = openType;
	}

	/**
	 * 获取操作人
	 */
	public String getOperator() {
		return this.operator;
	}

	/**
	 * 设置操作人
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * 获取封禁条件
	 */
	public String getParameter() {
		return this.parameter;
	}

	/**
	 * 设置封禁条件
	 */
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	/**
	 * 获取封禁状态
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 设置封禁状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取封禁类型
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * 设置封禁类型
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

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
 * 表名：log_limit_record
 * <p>
 * 描述：
 */
public class LogLimitRecord extends BaseEntity implements Serializable {
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
	 * 玩家广告id
	 */
	private String adId;
	/**
	 * 备注信息
	 */
	private String detail;
	/**
	 * 玩家设备id
	 */
	private String devUniqueId;
	/**
	 * 玩家ip
	 */
	private String ip;
	/**
	 * 操作人
	 */
	private String operator;
	/**
	 * 限制类型
	 */
	private String type;
	/**
	 * 业务方法
	 */
	private String userAction;

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
	 * 获取玩家广告id
	 */
	public String getAdId() {
		return this.adId;
	}

	/**
	 * 设置玩家广告id
	 */
	public void setAdId(String adId) {
		this.adId = adId;
	}

	/**
	 * 获取备注信息
	 */
	public String getDetail() {
		return this.detail;
	}

	/**
	 * 设置备注信息
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * 获取玩家设备id
	 */
	public String getDevUniqueId() {
		return this.devUniqueId;
	}

	/**
	 * 设置玩家设备id
	 */
	public void setDevUniqueId(String devUniqueId) {
		this.devUniqueId = devUniqueId;
	}

	/**
	 * 获取玩家ip
	 */
	public String getIp() {
		return this.ip;
	}

	/**
	 * 设置玩家ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
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
	 * 获取限制类型
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * 设置限制类型
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取业务方法
	 */
	public String getUserAction() {
		return this.userAction;
	}

	/**
	 * 设置业务方法
	 */
	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

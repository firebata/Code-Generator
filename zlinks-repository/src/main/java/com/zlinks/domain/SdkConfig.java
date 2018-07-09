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
 * 表名：sdk_config
 * <p>
 * 描述：
 */
public class SdkConfig extends BaseEntity implements Serializable {
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
	 * 配置项
	 */
	private String configKey;
	/**
	 * 配置值
	 */
	private String configValue;
	/**
	 * 附加信息
	 */
	private String detail;
	/**
	 * 操作者
	 */
	private String operator;
	/**
	 * 配置类型
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
	 * 获取配置项
	 */
	public String getConfigKey() {
		return this.configKey;
	}

	/**
	 * 设置配置项
	 */
	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	/**
	 * 获取配置值
	 */
	public String getConfigValue() {
		return this.configValue;
	}

	/**
	 * 设置配置值
	 */
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	/**
	 * 获取附加信息
	 */
	public String getDetail() {
		return this.detail;
	}

	/**
	 * 设置附加信息
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * 获取操作者
	 */
	public String getOperator() {
		return this.operator;
	}

	/**
	 * 设置操作者
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * 获取配置类型
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * 设置配置类型
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

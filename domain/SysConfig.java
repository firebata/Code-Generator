package com.zlinks.domain/;

import com.hpxs.base.BaseEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.math.BigInteger;
import java.util.Date;

/**
 * 实体bean
 * <p>
 * 表名：sys_config
 * <p>
 * 描述：
 */
public class SysConfig extends BaseEntity implements Serializable {
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
	 * key
	 */
	private String configKey;
	/**
	 * value
	 */
	private String configValue;
	/**
	 * 配置类型
	 */
	private String type;
	/**
	 * 备注
	 */
	private String remark;

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
	 * 获取key
	 */
	public String getConfigKey() {
		return this.configKey;
	}

	/**
	 * 设置key
	 */
	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	/**
	 * 获取value
	 */
	public String getConfigValue() {
		return this.configValue;
	}

	/**
	 * 设置value
	 */
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
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

	/**
	 * 获取备注
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 设置备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

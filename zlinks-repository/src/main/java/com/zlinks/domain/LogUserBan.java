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
 * 表名：log_user_ban
 * <p>
 * 描述：
 */
public class LogUserBan extends BaseEntity implements Serializable {
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
	 * 封禁内容
	 */
	private String banContent;
	/**
	 * 后台管理账号
	 */
	private String managerAccount;
	/**
	 * 封禁/解封
	 */
	private String operationType;
	/**
	 * 封禁/解封类型
	 */
	private String userBanType;
	/**
	 * 封禁/解封
	 */
	private String operationBanType;

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
	 * 获取封禁内容
	 */
	public String getBanContent() {
		return this.banContent;
	}

	/**
	 * 设置封禁内容
	 */
	public void setBanContent(String banContent) {
		this.banContent = banContent;
	}

	/**
	 * 获取后台管理账号
	 */
	public String getManagerAccount() {
		return this.managerAccount;
	}

	/**
	 * 设置后台管理账号
	 */
	public void setManagerAccount(String managerAccount) {
		this.managerAccount = managerAccount;
	}

	/**
	 * 获取封禁/解封
	 */
	public String getOperationType() {
		return this.operationType;
	}

	/**
	 * 设置封禁/解封
	 */
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	/**
	 * 获取封禁/解封类型
	 */
	public String getUserBanType() {
		return this.userBanType;
	}

	/**
	 * 设置封禁/解封类型
	 */
	public void setUserBanType(String userBanType) {
		this.userBanType = userBanType;
	}

	/**
	 * 获取封禁/解封
	 */
	public String getOperationBanType() {
		return this.operationBanType;
	}

	/**
	 * 设置封禁/解封
	 */
	public void setOperationBanType(String operationBanType) {
		this.operationBanType = operationBanType;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

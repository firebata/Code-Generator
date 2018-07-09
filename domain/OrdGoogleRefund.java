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
 * 表名：ord_google_refund
 * <p>
 * 描述：
 */
public class OrdGoogleRefund extends BaseEntity implements Serializable {
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
	 * 购买时间
	 */
	private String purchaseTime;
	/**
	 * google支付token
	 */
	private String purchaseToken;
	/**
	 * google支付token hashcode
	 */
	private Integer tokenHashCode;
	/**
	 * 退款时间
	 */
	private String voidedTime;

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
	 * 获取购买时间
	 */
	public String getPurchaseTime() {
		return this.purchaseTime;
	}

	/**
	 * 设置购买时间
	 */
	public void setPurchaseTime(String purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	/**
	 * 获取google支付token
	 */
	public String getPurchaseToken() {
		return this.purchaseToken;
	}

	/**
	 * 设置google支付token
	 */
	public void setPurchaseToken(String purchaseToken) {
		this.purchaseToken = purchaseToken;
	}

	/**
	 * 获取google支付token hashcode
	 */
	public Integer getTokenHashCode() {
		return this.tokenHashCode;
	}

	/**
	 * 设置google支付token hashcode
	 */
	public void setTokenHashCode(Integer tokenHashCode) {
		this.tokenHashCode = tokenHashCode;
	}

	/**
	 * 获取退款时间
	 */
	public String getVoidedTime() {
		return this.voidedTime;
	}

	/**
	 * 设置退款时间
	 */
	public void setVoidedTime(String voidedTime) {
		this.voidedTime = voidedTime;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

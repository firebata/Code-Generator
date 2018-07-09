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
 * 表名：ord_pay
 * <p>
 * 描述：
 */
public class OrdPay extends BaseEntity implements Serializable {
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
	 * 渠道订单id
	 */
	private String channelOrderNum;
	/**
	 * 订单处理类型
	 */
	private String dataSourceType;
	/**
	 * 订单唯一id
	 */
	private String orderNum;
	/**
	 * 充值返回信息
	 */
	private String payResult;
	/**
	 * google签名信息
	 */
	private String signature;
	/**
	 * 谷歌订单支付token
	 */
	private String payToken;
	/**
	 * 三星协议版本号
	 */
	private String protocolVersion;
	/**
	 * purchaseDate
	 */
	private String purchaseDate;

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
	 * 获取渠道订单id
	 */
	public String getChannelOrderNum() {
		return this.channelOrderNum;
	}

	/**
	 * 设置渠道订单id
	 */
	public void setChannelOrderNum(String channelOrderNum) {
		this.channelOrderNum = channelOrderNum;
	}

	/**
	 * 获取订单处理类型
	 */
	public String getDataSourceType() {
		return this.dataSourceType;
	}

	/**
	 * 设置订单处理类型
	 */
	public void setDataSourceType(String dataSourceType) {
		this.dataSourceType = dataSourceType;
	}

	/**
	 * 获取订单唯一id
	 */
	public String getOrderNum() {
		return this.orderNum;
	}

	/**
	 * 设置订单唯一id
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * 获取充值返回信息
	 */
	public String getPayResult() {
		return this.payResult;
	}

	/**
	 * 设置充值返回信息
	 */
	public void setPayResult(String payResult) {
		this.payResult = payResult;
	}

	/**
	 * 获取google签名信息
	 */
	public String getSignature() {
		return this.signature;
	}

	/**
	 * 设置google签名信息
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

	/**
	 * 获取谷歌订单支付token
	 */
	public String getPayToken() {
		return this.payToken;
	}

	/**
	 * 设置谷歌订单支付token
	 */
	public void setPayToken(String payToken) {
		this.payToken = payToken;
	}

	/**
	 * 获取三星协议版本号
	 */
	public String getProtocolVersion() {
		return this.protocolVersion;
	}

	/**
	 * 设置三星协议版本号
	 */
	public void setProtocolVersion(String protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	/**
	 * 获取purchaseDate
	 */
	public String getPurchaseDate() {
		return this.purchaseDate;
	}

	/**
	 * 设置purchaseDate
	 */
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

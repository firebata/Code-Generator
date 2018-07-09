package com.zlinks.domain/;

import com.hpxs.base.BaseEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体bean
 * <p>
 * 表名：ord_notify
 * <p>
 * 描述：
 */
public class OrdNotify extends BaseEntity implements Serializable {
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
	 * 金额
	 */
	private String amount;
	/**
	 * 游戏透传回传参数
	 */
	private String attach;
	/**
	 * 支付渠道类型
	 */
	private BigInteger channelId;
	/**
	 * 通知字符串
	 */
	private String content;
	/**
	 * 渠道订单id
	 */
	private String cpOrderNum;
	/**
	 * 游戏唯一id
	 */
	private BigInteger gameId;
	/**
	 * 游戏包名
	 */
	private BigInteger gamePackageId;
	/**
	 * 订单唯一id
	 */
	private String orderNum;
	/**
	 * 订单创建时间
	 */
	private String payTime;
	/**
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 通知结果编码
	 */
	private String resultCode;
	/**
	 * 通知结果信息
	 */
	private String resultMsg;
	/**
	 * 通知状态，0：失败，1：成功
	 */
	private String status;
	/**
	 * 用户id
	 */
	private BigInteger userId;
	/**
	 * 备注信息
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
	 * 获取金额
	 */
	public String getAmount() {
		return this.amount;
	}

	/**
	 * 设置金额
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * 获取游戏透传回传参数
	 */
	public String getAttach() {
		return this.attach;
	}

	/**
	 * 设置游戏透传回传参数
	 */
	public void setAttach(String attach) {
		this.attach = attach;
	}

	/**
	 * 获取支付渠道类型
	 */
	public BigInteger getChannelId() {
		return this.channelId;
	}

	/**
	 * 设置支付渠道类型
	 */
	public void setChannelId(BigInteger channelId) {
		this.channelId = channelId;
	}

	/**
	 * 获取通知字符串
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * 设置通知字符串
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取渠道订单id
	 */
	public String getCpOrderNum() {
		return this.cpOrderNum;
	}

	/**
	 * 设置渠道订单id
	 */
	public void setCpOrderNum(String cpOrderNum) {
		this.cpOrderNum = cpOrderNum;
	}

	/**
	 * 获取游戏唯一id
	 */
	public BigInteger getGameId() {
		return this.gameId;
	}

	/**
	 * 设置游戏唯一id
	 */
	public void setGameId(BigInteger gameId) {
		this.gameId = gameId;
	}

	/**
	 * 获取游戏包名
	 */
	public BigInteger getGamePackageId() {
		return this.gamePackageId;
	}

	/**
	 * 设置游戏包名
	 */
	public void setGamePackageId(BigInteger gamePackageId) {
		this.gamePackageId = gamePackageId;
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
	 * 获取订单创建时间
	 */
	public String getPayTime() {
		return this.payTime;
	}

	/**
	 * 设置订单创建时间
	 */
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	/**
	 * 获取价格
	 */
	public BigDecimal getPrice() {
		return this.price;
	}

	/**
	 * 设置价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * 获取通知结果编码
	 */
	public String getResultCode() {
		return this.resultCode;
	}

	/**
	 * 设置通知结果编码
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * 获取通知结果信息
	 */
	public String getResultMsg() {
		return this.resultMsg;
	}

	/**
	 * 设置通知结果信息
	 */
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	/**
	 * 获取通知状态，0：失败，1：成功
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 设置通知状态，0：失败，1：成功
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取用户id
	 */
	public BigInteger getUserId() {
		return this.userId;
	}

	/**
	 * 设置用户id
	 */
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	/**
	 * 获取备注信息
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 设置备注信息
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

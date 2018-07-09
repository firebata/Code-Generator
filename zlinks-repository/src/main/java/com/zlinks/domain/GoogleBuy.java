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
 * 表名：google_buy
 * <p>
 * 描述：
 */
public class GoogleBuy extends BaseEntity implements Serializable {
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
	 * 描述
	 */
	private String description;
	/**
	 * 购买日期
	 */
	private String transactionDate;
	/**
	 * 购买时间
	 */
	private String transactionTime;
	/**
	 * 玩家账号
	 */
	private String taxType;
	/**
	 * 购买类型
	 */
	private String transactionType;
	/**
	 * 退款类型
	 */
	private String refundType;
	/**
	 * Product Title
	 */
	private String productTitle;
	/**
	 * packageId
	 */
	private String productId;
	/**
	 * 产品蕾西
	 */
	private String productType;
	/**
	 * 产品品相
	 */
	private String skuId;
	/**
	 * 手机硬件
	 */
	private String hardware;
	/**
	 * 购买城市
	 */
	private String buyer Country;
	/**
	 * 购买地区
	 */
	private String buyer State;
	/**
	 * 购买邮编
	 */
	private String buyer Postal Code;
	/**
	 * 货币类型
	 */
	private String buyer Currency;
	/**
	 * 金额
	 */
	private String amount;
	/**
	 * 货币汇率
	 */
	private String currency Conversion;
	/**
	 * Rate
	 */
	private String rate;
	/**
	 * 商户货币
	 */
	private String merchant Currency;
	/**
	 * 商户金额
	 */
	private String merchantAmount;

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
	 * 获取描述
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * 设置描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取购买日期
	 */
	public String getTransactionDate() {
		return this.transactionDate;
	}

	/**
	 * 设置购买日期
	 */
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * 获取购买时间
	 */
	public String getTransactionTime() {
		return this.transactionTime;
	}

	/**
	 * 设置购买时间
	 */
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	/**
	 * 获取玩家账号
	 */
	public String getTaxType() {
		return this.taxType;
	}

	/**
	 * 设置玩家账号
	 */
	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	/**
	 * 获取购买类型
	 */
	public String getTransactionType() {
		return this.transactionType;
	}

	/**
	 * 设置购买类型
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * 获取退款类型
	 */
	public String getRefundType() {
		return this.refundType;
	}

	/**
	 * 设置退款类型
	 */
	public void setRefundType(String refundType) {
		this.refundType = refundType;
	}

	/**
	 * 获取Product Title
	 */
	public String getProductTitle() {
		return this.productTitle;
	}

	/**
	 * 设置Product Title
	 */
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	/**
	 * 获取packageId
	 */
	public String getProductId() {
		return this.productId;
	}

	/**
	 * 设置packageId
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * 获取产品蕾西
	 */
	public String getProductType() {
		return this.productType;
	}

	/**
	 * 设置产品蕾西
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * 获取产品品相
	 */
	public String getSkuId() {
		return this.skuId;
	}

	/**
	 * 设置产品品相
	 */
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	/**
	 * 获取手机硬件
	 */
	public String getHardware() {
		return this.hardware;
	}

	/**
	 * 设置手机硬件
	 */
	public void setHardware(String hardware) {
		this.hardware = hardware;
	}

	/**
	 * 获取购买城市
	 */
	public String getBuyer Country() {
		return this.buyer Country;
	}

	/**
	 * 设置购买城市
	 */
	public void setBuyer Country(String buyer Country) {
		this.buyer Country = buyer Country;
	}

	/**
	 * 获取购买地区
	 */
	public String getBuyer State() {
		return this.buyer State;
	}

	/**
	 * 设置购买地区
	 */
	public void setBuyer State(String buyer State) {
		this.buyer State = buyer State;
	}

	/**
	 * 获取购买邮编
	 */
	public String getBuyer Postal Code() {
		return this.buyer Postal Code;
	}

	/**
	 * 设置购买邮编
	 */
	public void setBuyer Postal Code(String buyer Postal Code) {
		this.buyer Postal Code = buyer Postal Code;
	}

	/**
	 * 获取货币类型
	 */
	public String getBuyer Currency() {
		return this.buyer Currency;
	}

	/**
	 * 设置货币类型
	 */
	public void setBuyer Currency(String buyer Currency) {
		this.buyer Currency = buyer Currency;
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
	 * 获取货币汇率
	 */
	public String getCurrency Conversion() {
		return this.currency Conversion;
	}

	/**
	 * 设置货币汇率
	 */
	public void setCurrency Conversion(String currency Conversion) {
		this.currency Conversion = currency Conversion;
	}

	/**
	 * 获取Rate
	 */
	public String getRate() {
		return this.rate;
	}

	/**
	 * 设置Rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}

	/**
	 * 获取商户货币
	 */
	public String getMerchant Currency() {
		return this.merchant Currency;
	}

	/**
	 * 设置商户货币
	 */
	public void setMerchant Currency(String merchant Currency) {
		this.merchant Currency = merchant Currency;
	}

	/**
	 * 获取商户金额
	 */
	public String getMerchantAmount() {
		return this.merchantAmount;
	}

	/**
	 * 设置商户金额
	 */
	public void setMerchantAmount(String merchantAmount) {
		this.merchantAmount = merchantAmount;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

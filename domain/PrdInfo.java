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
 * 表名：prd_info
 * <p>
 * 描述：
 */
public class PrdInfo extends BaseEntity implements Serializable {
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
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 产品描述
	 */
	private String productDescription;
	/**
	 * 外部产品id
	 */
	private String productId;
	/**
	 * 产品类型
	 */
	private String type;
	/**
	 * 游戏id
	 */
	private BigInteger gameId;

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
	 * 获取产品描述
	 */
	public String getProductDescription() {
		return this.productDescription;
	}

	/**
	 * 设置产品描述
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * 获取外部产品id
	 */
	public String getProductId() {
		return this.productId;
	}

	/**
	 * 设置外部产品id
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * 获取产品类型
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * 设置产品类型
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取游戏id
	 */
	public BigInteger getGameId() {
		return this.gameId;
	}

	/**
	 * 设置游戏id
	 */
	public void setGameId(BigInteger gameId) {
		this.gameId = gameId;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

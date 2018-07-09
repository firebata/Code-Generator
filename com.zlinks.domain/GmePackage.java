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
 * 表名：gme_package
 * <p>
 * 描述：
 */
public class GmePackage extends BaseEntity implements Serializable {
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
	 * 游戏id
	 */
	private BigInteger gameId;
	/**
	 * 游戏包
	 */
	private String name;
	/**
	 * oneStoreAppId
	 */
	private String oneStoreAppId;

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

	/**
	 * 获取游戏包
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 设置游戏包
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取oneStoreAppId
	 */
	public String getOneStoreAppId() {
		return this.oneStoreAppId;
	}

	/**
	 * 设置oneStoreAppId
	 */
	public void setOneStoreAppId(String oneStoreAppId) {
		this.oneStoreAppId = oneStoreAppId;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

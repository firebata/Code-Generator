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
 * 表名：usr_game_account
 * <p>
 * 描述：
 */
public class UsrGameAccount extends BaseEntity implements Serializable {
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
	 * 广告id
	 */
	private String adId;
	/**
	 * 渠道id
	 */
	private BigInteger channelId;
	/**
	 * 城市名称
	 */
	private String city;
	/**
	 * 
	 */
	private String countryCode;
	/**
	 * 游戏包名
	 */
	private BigInteger gameId;
	/**
	 * ip地址
	 */
	private String ip;
	/**
	 * 操作系统
	 */
	private String os;
	/**
	 * 游戏账号状态
	 */
	private Integer state;
	/**
	 * 用户id
	 */
	private BigInteger userId;

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
	 * 获取广告id
	 */
	public String getAdId() {
		return this.adId;
	}

	/**
	 * 设置广告id
	 */
	public void setAdId(String adId) {
		this.adId = adId;
	}

	/**
	 * 获取渠道id
	 */
	public BigInteger getChannelId() {
		return this.channelId;
	}

	/**
	 * 设置渠道id
	 */
	public void setChannelId(BigInteger channelId) {
		this.channelId = channelId;
	}

	/**
	 * 获取城市名称
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * 设置城市名称
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 获取
	 */
	public String getCountryCode() {
		return this.countryCode;
	}

	/**
	 * 设置
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * 获取游戏包名
	 */
	public BigInteger getGameId() {
		return this.gameId;
	}

	/**
	 * 设置游戏包名
	 */
	public void setGameId(BigInteger gameId) {
		this.gameId = gameId;
	}

	/**
	 * 获取ip地址
	 */
	public String getIp() {
		return this.ip;
	}

	/**
	 * 设置ip地址
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 获取操作系统
	 */
	public String getOs() {
		return this.os;
	}

	/**
	 * 设置操作系统
	 */
	public void setOs(String os) {
		this.os = os;
	}

	/**
	 * 获取游戏账号状态
	 */
	public Integer getState() {
		return this.state;
	}

	/**
	 * 设置游戏账号状态
	 */
	public void setState(Integer state) {
		this.state = state;
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

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

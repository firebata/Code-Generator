package com.zlinks.domain;

import com.hpxs.base.BaseEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.math.BigInteger;
import java.util.Date;

/**
 * 实体bean
 * <p>
 * 表名：log_user_register
 * <p>
 * 描述：
 */
public class LogUserRegister extends BaseEntity implements Serializable {
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
	 * 广告id
	 */
	private String adId;
	/**
	 * 区域ID
	 */
	private String areaId;
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
	 * 设备号
	 */
	private String devUniqueId;
	/**
	 * 注册邮箱
	 */
	private String email;
	/**
	 * 游戏id
	 */
	private BigInteger gameId;
	/**
	 * ip地址
	 */
	private String ip;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 手机型号
	 */
	private String model;
	/**
	 * 玩家昵称
	 */
	private String nickName;
	/**
	 * 登录类型
	 */
	private String openType;
	/**
	 * 终端系统
	 */
	private String os;
	/**
	 * 游戏包
	 */
	private String packageId;
	/**
	 * 用户id
	 */
	private BigInteger userId;
	/**
	 * 用户uid
	 */
	private String usrUid;
	/**
	 * 游戏版本号
	 */
	private BigInteger versionId;

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
	 * 获取区域ID
	 */
	public String getAreaId() {
		return this.areaId;
	}

	/**
	 * 设置区域ID
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
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
	 * 获取设备号
	 */
	public String getDevUniqueId() {
		return this.devUniqueId;
	}

	/**
	 * 设置设备号
	 */
	public void setDevUniqueId(String devUniqueId) {
		this.devUniqueId = devUniqueId;
	}

	/**
	 * 获取注册邮箱
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * 设置注册邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * 获取手机号码
	 */
	public String getMobile() {
		return this.mobile;
	}

	/**
	 * 设置手机号码
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取手机型号
	 */
	public String getModel() {
		return this.model;
	}

	/**
	 * 设置手机型号
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * 获取玩家昵称
	 */
	public String getNickName() {
		return this.nickName;
	}

	/**
	 * 设置玩家昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 获取登录类型
	 */
	public String getOpenType() {
		return this.openType;
	}

	/**
	 * 设置登录类型
	 */
	public void setOpenType(String openType) {
		this.openType = openType;
	}

	/**
	 * 获取终端系统
	 */
	public String getOs() {
		return this.os;
	}

	/**
	 * 设置终端系统
	 */
	public void setOs(String os) {
		this.os = os;
	}

	/**
	 * 获取游戏包
	 */
	public String getPackageId() {
		return this.packageId;
	}

	/**
	 * 设置游戏包
	 */
	public void setPackageId(String packageId) {
		this.packageId = packageId;
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
	 * 获取用户uid
	 */
	public String getUsrUid() {
		return this.usrUid;
	}

	/**
	 * 设置用户uid
	 */
	public void setUsrUid(String usrUid) {
		this.usrUid = usrUid;
	}

	/**
	 * 获取游戏版本号
	 */
	public BigInteger getVersionId() {
		return this.versionId;
	}

	/**
	 * 设置游戏版本号
	 */
	public void setVersionId(BigInteger versionId) {
		this.versionId = versionId;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

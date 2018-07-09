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
 * 表名：log_device
 * <p>
 * 描述：
 */
public class LogDevice extends BaseEntity implements Serializable {
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
	 * 区域ID
	 */
	private String areaId;
	/**
	 * 渠道id
	 */
	private BigInteger channelId;
	/**
	 * 设备号
	 */
	private String devUniqueId;
	/**
	 * 游戏id
	 */
	private BigInteger gameId;
	/**
	 * 终端系统
	 */
	private String os;
	/**
	 * 游戏包
	 */
	private String packageId;
	/**
	 * 用户操作url
	 */
	private String uri;
	/**
	 * 用户id
	 */
	private BigInteger userId;
	/**
	 * 游戏版本号
	 */
	private String versionId;
	/**
	 * 请求字节数
	 */
	private BigInteger bytes;
	/**
	 * 请求状态码
	 */
	private String response;
	/**
	 * 返回状态码
	 */
	private String status;
	/**
	 * 用户代理
	 */
	private String userAgent;
	/**
	 * 世界协调时
	 */
	private String utcTimeStr;
	/**
	 * ip
	 */
	private String ip;
	/**
	 * 世界协调时
	 */
	private String utcTimeVal;

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
	 * 获取用户操作url
	 */
	public String getUri() {
		return this.uri;
	}

	/**
	 * 设置用户操作url
	 */
	public void setUri(String uri) {
		this.uri = uri;
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
	 * 获取游戏版本号
	 */
	public String getVersionId() {
		return this.versionId;
	}

	/**
	 * 设置游戏版本号
	 */
	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	/**
	 * 获取请求字节数
	 */
	public BigInteger getBytes() {
		return this.bytes;
	}

	/**
	 * 设置请求字节数
	 */
	public void setBytes(BigInteger bytes) {
		this.bytes = bytes;
	}

	/**
	 * 获取请求状态码
	 */
	public String getResponse() {
		return this.response;
	}

	/**
	 * 设置请求状态码
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	/**
	 * 获取返回状态码
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 设置返回状态码
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取用户代理
	 */
	public String getUserAgent() {
		return this.userAgent;
	}

	/**
	 * 设置用户代理
	 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	/**
	 * 获取世界协调时
	 */
	public String getUtcTimeStr() {
		return this.utcTimeStr;
	}

	/**
	 * 设置世界协调时
	 */
	public void setUtcTimeStr(String utcTimeStr) {
		this.utcTimeStr = utcTimeStr;
	}

	/**
	 * 获取ip
	 */
	public String getIp() {
		return this.ip;
	}

	/**
	 * 设置ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 获取世界协调时
	 */
	public String getUtcTimeVal() {
		return this.utcTimeVal;
	}

	/**
	 * 设置世界协调时
	 */
	public void setUtcTimeVal(String utcTimeVal) {
		this.utcTimeVal = utcTimeVal;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

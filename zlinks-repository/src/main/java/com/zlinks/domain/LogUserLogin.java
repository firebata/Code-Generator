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
 * 表名：log_user_login
 * <p>
 * 描述：
 */
public class LogUserLogin extends BaseEntity implements Serializable {
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
	 * 游戏渠道
	 */
	private BigInteger channelId;
	/**
	 * 游戏包名
	 */
	private BigInteger gameId;
	/**
	 * ip地址
	 */
	private String ip;
	/**
	 * 玩家等级
	 */
	private Integer level;
	/**
	 * 登录次数统计
	 */
	private Integer logCount;
	/**
	 * 登录类型
	 */
	private String openType;
	/**
	 * 操作系统类型
	 */
	private String os;
	/**
	 * 玩家角色id
	 */
	private String roleId;
	/**
	 * 玩家角色名称
	 */
	private String roleName;
	/**
	 * 区服id
	 */
	private String serverId;
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
	 * 获取游戏渠道
	 */
	public BigInteger getChannelId() {
		return this.channelId;
	}

	/**
	 * 设置游戏渠道
	 */
	public void setChannelId(BigInteger channelId) {
		this.channelId = channelId;
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
	 * 获取玩家等级
	 */
	public Integer getLevel() {
		return this.level;
	}

	/**
	 * 设置玩家等级
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * 获取登录次数统计
	 */
	public Integer getLogCount() {
		return this.logCount;
	}

	/**
	 * 设置登录次数统计
	 */
	public void setLogCount(Integer logCount) {
		this.logCount = logCount;
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
	 * 获取操作系统类型
	 */
	public String getOs() {
		return this.os;
	}

	/**
	 * 设置操作系统类型
	 */
	public void setOs(String os) {
		this.os = os;
	}

	/**
	 * 获取玩家角色id
	 */
	public String getRoleId() {
		return this.roleId;
	}

	/**
	 * 设置玩家角色id
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取玩家角色名称
	 */
	public String getRoleName() {
		return this.roleName;
	}

	/**
	 * 设置玩家角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * 获取区服id
	 */
	public String getServerId() {
		return this.serverId;
	}

	/**
	 * 设置区服id
	 */
	public void setServerId(String serverId) {
		this.serverId = serverId;
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

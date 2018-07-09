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
 * 表名：log_cus_app_package_report
 * <p>
 * 描述：
 */
public class LogCusAppPackageReport extends BaseEntity implements Serializable {
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
	 * 游戏包名
	 */
	private BigInteger gameId;
	/**
	 * 包名
	 */
	private String packageName;
	/**
	 * 玩家角色id
	 */
	private String roleId;
	/**
	 * 玩家等级
	 */
	private Integer roleLevel;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 区服id
	 */
	private String serverId;
	/**
	 * 区服名称
	 */
	private String serverName;
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
	 * 获取包名
	 */
	public String getPackageName() {
		return this.packageName;
	}

	/**
	 * 设置包名
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
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
	 * 获取玩家等级
	 */
	public Integer getRoleLevel() {
		return this.roleLevel;
	}

	/**
	 * 设置玩家等级
	 */
	public void setRoleLevel(Integer roleLevel) {
		this.roleLevel = roleLevel;
	}

	/**
	 * 获取角色名称
	 */
	public String getRoleName() {
		return this.roleName;
	}

	/**
	 * 设置角色名称
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
	 * 获取区服名称
	 */
	public String getServerName() {
		return this.serverName;
	}

	/**
	 * 设置区服名称
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName;
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

package com.zlinks.domain/;

import com.hpxs.base.BaseEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.math.BigInteger;
import java.util.Date;

/**
 * 实体bean
 * <p>
 * 表名：clt_complaint
 * <p>
 * 描述：
 */
public class CltComplaint extends BaseEntity implements Serializable {
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
	 * 客诉投诉问题内容
	 */
	private String content;
	/**
	 * 设备号
	 */
	private String devUniqueId;
	/**
	 * 游戏包名
	 */
	private BigInteger gameId;
	/**
	 * 手机型号
	 */
	private String model;
	/**
	 * 操作系统
	 */
	private String os;
	/**
	 * 操作系统版本
	 */
	private String osVersion;
	/**
	 * 
	 */
	private String picUrl;
	/**
	 * 玩家角色id
	 */
	private String roleId;
	/**
	 * 区服id
	 */
	private String serverId;
	/**
	 * 问题的回复状态分类:FINISHED("已处理"), REPLYED("已回复"), UNDEALED("未处理")
	 */
	private String status;
	/**
	 * 客诉问题类型: RECHARGE("储值问题"), ACCOUNT("账号问题"), Raiders("攻略问题"), QUERY("查询记录问题"), SUGGEST("建议及反馈"), BUG("BUG问题"), OTHERS("其他问题")
	 */
	private String type;
	/**
	 * 用户id
	 */
	private BigInteger userId;
	/**
	 * 后台管理账号
	 */
	private String managerAccount;

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
	 * 获取客诉投诉问题内容
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * 设置客诉投诉问题内容
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * 获取操作系统版本
	 */
	public String getOsVersion() {
		return this.osVersion;
	}

	/**
	 * 设置操作系统版本
	 */
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	/**
	 * 获取
	 */
	public String getPicUrl() {
		return this.picUrl;
	}

	/**
	 * 设置
	 */
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
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
	 * 获取问题的回复状态分类:FINISHED("已处理"), REPLYED("已回复"), UNDEALED("未处理")
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 设置问题的回复状态分类:FINISHED("已处理"), REPLYED("已回复"), UNDEALED("未处理")
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取客诉问题类型: RECHARGE("储值问题"), ACCOUNT("账号问题"), Raiders("攻略问题"), QUERY("查询记录问题"), SUGGEST("建议及反馈"), BUG("BUG问题"), OTHERS("其他问题")
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * 设置客诉问题类型: RECHARGE("储值问题"), ACCOUNT("账号问题"), Raiders("攻略问题"), QUERY("查询记录问题"), SUGGEST("建议及反馈"), BUG("BUG问题"), OTHERS("其他问题")
	 */
	public void setType(String type) {
		this.type = type;
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
	 * 获取后台管理账号
	 */
	public String getManagerAccount() {
		return this.managerAccount;
	}

	/**
	 * 设置后台管理账号
	 */
	public void setManagerAccount(String managerAccount) {
		this.managerAccount = managerAccount;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

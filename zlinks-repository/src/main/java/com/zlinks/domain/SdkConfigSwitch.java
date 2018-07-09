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
 * 表名：sdk_config_switch
 * <p>
 * 描述：
 */
public class SdkConfigSwitch extends BaseEntity implements Serializable {
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
	 * 巴哈姆特地址
	 */
	private String bhmtUrl;
	/**
	 * 附加配置信息
	 */
	private String detail;
	/**
	 * facebook App粉丝圈地址
	 */
	private String fbAppFansUrl;
	/**
	 * facebook 网页粉丝圈地址
	 */
	private String fbWebFansUrl;
	/**
	 * 游戏唯一id
	 */
	private BigInteger gameId;
	/**
	 * 游戏攻略地址
	 */
	private String gameManualUrl;
	/**
	 * 操作名称
	 */
	private String name;
	/**
	 * 游戏包id
	 */
	private BigInteger packageId;
	/**
	 * 游戏包名
	 */
	private String packageName;
	/**
	 * 配置类型
	 */
	private String type;
	/**
	 * 操作值
	 */
	private String value;
	/**
	 * 操作值
	 */
	private String configValue;

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
	 * 获取巴哈姆特地址
	 */
	public String getBhmtUrl() {
		return this.bhmtUrl;
	}

	/**
	 * 设置巴哈姆特地址
	 */
	public void setBhmtUrl(String bhmtUrl) {
		this.bhmtUrl = bhmtUrl;
	}

	/**
	 * 获取附加配置信息
	 */
	public String getDetail() {
		return this.detail;
	}

	/**
	 * 设置附加配置信息
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * 获取facebook App粉丝圈地址
	 */
	public String getFbAppFansUrl() {
		return this.fbAppFansUrl;
	}

	/**
	 * 设置facebook App粉丝圈地址
	 */
	public void setFbAppFansUrl(String fbAppFansUrl) {
		this.fbAppFansUrl = fbAppFansUrl;
	}

	/**
	 * 获取facebook 网页粉丝圈地址
	 */
	public String getFbWebFansUrl() {
		return this.fbWebFansUrl;
	}

	/**
	 * 设置facebook 网页粉丝圈地址
	 */
	public void setFbWebFansUrl(String fbWebFansUrl) {
		this.fbWebFansUrl = fbWebFansUrl;
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
	 * 获取游戏攻略地址
	 */
	public String getGameManualUrl() {
		return this.gameManualUrl;
	}

	/**
	 * 设置游戏攻略地址
	 */
	public void setGameManualUrl(String gameManualUrl) {
		this.gameManualUrl = gameManualUrl;
	}

	/**
	 * 获取操作名称
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 设置操作名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取游戏包id
	 */
	public BigInteger getPackageId() {
		return this.packageId;
	}

	/**
	 * 设置游戏包id
	 */
	public void setPackageId(BigInteger packageId) {
		this.packageId = packageId;
	}

	/**
	 * 获取游戏包名
	 */
	public String getPackageName() {
		return this.packageName;
	}

	/**
	 * 设置游戏包名
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	/**
	 * 获取配置类型
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * 设置配置类型
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取操作值
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * 设置操作值
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 获取操作值
	 */
	public String getConfigValue() {
		return this.configValue;
	}

	/**
	 * 设置操作值
	 */
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

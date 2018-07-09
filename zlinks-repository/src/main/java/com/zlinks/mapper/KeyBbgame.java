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
 * 表名：key_bbgame
 * <p>
 * 描述：
 */
public class KeyBbgame extends BaseEntity implements Serializable {
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
	 * 用途
	 */
	private String ausage;
	/**
	 * 密钥
	 */
	private String privateKey;
	/**
	 * 公钥
	 */
	private String publicKey;
	/**
	 * 第三方接口登录id:usr_third表的id
	 */
	private BigInteger userThirdId;
	/**
	 * 第三方接口登录uid:usr_third表的uid
	 */
	private String userThirdUid;

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
	 * 获取用途
	 */
	public String getAusage() {
		return this.ausage;
	}

	/**
	 * 设置用途
	 */
	public void setAusage(String ausage) {
		this.ausage = ausage;
	}

	/**
	 * 获取密钥
	 */
	public String getPrivateKey() {
		return this.privateKey;
	}

	/**
	 * 设置密钥
	 */
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	/**
	 * 获取公钥
	 */
	public String getPublicKey() {
		return this.publicKey;
	}

	/**
	 * 设置公钥
	 */
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	/**
	 * 获取第三方接口登录id:usr_third表的id
	 */
	public BigInteger getUserThirdId() {
		return this.userThirdId;
	}

	/**
	 * 设置第三方接口登录id:usr_third表的id
	 */
	public void setUserThirdId(BigInteger userThirdId) {
		this.userThirdId = userThirdId;
	}

	/**
	 * 获取第三方接口登录uid:usr_third表的uid
	 */
	public String getUserThirdUid() {
		return this.userThirdUid;
	}

	/**
	 * 设置第三方接口登录uid:usr_third表的uid
	 */
	public void setUserThirdUid(String userThirdUid) {
		this.userThirdUid = userThirdUid;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

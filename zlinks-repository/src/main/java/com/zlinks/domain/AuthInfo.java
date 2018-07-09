package com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/;

import com.hpxs.base.BaseEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 实体bean
 * <p>
 * 表名：auth_info
 * <p>
 * 描述：
 */
public class AuthInfo extends BaseEntity implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private Integer authId;
	/**
	 * 
	 */
	private Integer parentAuthId;
	/**
	 * 
	 */
	private String authType;

	/**
	 * 获取
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * 设置
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取
	 */
	public Integer getAuthId() {
		return this.authId;
	}

	/**
	 * 设置
	 */
	public void setAuthId(Integer authId) {
		this.authId = authId;
	}

	/**
	 * 获取
	 */
	public Integer getParentAuthId() {
		return this.parentAuthId;
	}

	/**
	 * 设置
	 */
	public void setParentAuthId(Integer parentAuthId) {
		this.parentAuthId = parentAuthId;
	}

	/**
	 * 获取
	 */
	public String getAuthType() {
		return this.authType;
	}

	/**
	 * 设置
	 */
	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

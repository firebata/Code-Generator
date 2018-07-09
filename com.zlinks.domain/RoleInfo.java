package com.zlinks.com.zlinks.domain;

import com.hpxs.base.BaseEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 实体bean
 * <p>
 * 表名：role_info
 * <p>
 * 描述：
 */
public class RoleInfo extends BaseEntity implements Serializable {
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
	private Integer roleId;
	/**
	 * 
	 */
	private String roleName;

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
	public Integer getRoleId() {
		return this.roleId;
	}

	/**
	 * 设置
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取
	 */
	public String getRoleName() {
		return this.roleName;
	}

	/**
	 * 设置
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

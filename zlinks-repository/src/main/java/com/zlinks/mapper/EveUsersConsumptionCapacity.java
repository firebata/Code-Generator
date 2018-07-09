package com.zlinks.domain;

import com.hpxs.base.BaseEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 实体bean
 * <p>
 * 表名：eve_users_consumption_capacity
 * <p>
 * 描述：
 */
public class EveUsersConsumptionCapacity extends BaseEntity implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String userId;
	/**
	 * 
	 */
	private Integer total;

	/**
	 * 获取
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * 设置
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 获取
	 */
	public Integer getTotal() {
		return this.total;
	}

	/**
	 * 设置
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

package com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/;

import com.hpxs.base.BaseEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 实体bean
 * <p>
 * 表名：temp
 * <p>
 * 描述：
 */
public class Temp extends BaseEntity implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String name;

	/**
	 * 获取
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 设置
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

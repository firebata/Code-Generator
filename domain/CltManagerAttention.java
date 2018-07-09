package com.zlinks.domain/;

import com.hpxs.base.BaseEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

/**
 * 实体bean
 * <p>
 * 表名：clt_manager_attention
 * <p>
 * 描述：
 */
public class CltManagerAttention extends BaseEntity implements Serializable {
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
	private Date createdTime;
	/**
	 * 
	 */
	private Date updatedTime;
	/**
	 * 
	 */
	private Integer questionId;
	/**
	 * 
	 */
	private String managerName;
	/**
	 * 
	 */
	private Integer isDelete;

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
	public Date getCreatedTime() {
		return this.createdTime;
	}

	/**
	 * 设置
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * 获取
	 */
	public Date getUpdatedTime() {
		return this.updatedTime;
	}

	/**
	 * 设置
	 */
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	/**
	 * 获取
	 */
	public Integer getQuestionId() {
		return this.questionId;
	}

	/**
	 * 设置
	 */
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	/**
	 * 获取
	 */
	public String getManagerName() {
		return this.managerName;
	}

	/**
	 * 设置
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	/**
	 * 获取
	 */
	public Integer getIsDelete() {
		return this.isDelete;
	}

	/**
	 * 设置
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

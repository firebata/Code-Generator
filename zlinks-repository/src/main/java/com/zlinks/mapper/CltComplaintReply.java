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
 * 表名：clt_complaint_reply
 * <p>
 * 描述：
 */
public class CltComplaintReply extends BaseEntity implements Serializable {
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
	 * 客户投诉问题内容
	 */
	private String content;
	/**
	 * 回复用户类型 0:用户,1:答复者
	 */
	private Integer fromUser;
	/**
	 * 投诉问题id
	 */
	private BigInteger questionId;
	/**
	 * 用户id
	 */
	private BigInteger userId;
	/**
	 * 后台管理账号
	 */
	private String managerAccount;
	/**
	 * 问题的回复状态分类:FINISHED("已处理"), REPLYED("已回复"), UNDEALED("未处理")
	 */
	private String status;
	/**
	 * 游戏唯一id
	 */
	private BigInteger gameId;
	/**
	 * 回复评分
	 */
	private Integer star;

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
	 * 获取客户投诉问题内容
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * 设置客户投诉问题内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取回复用户类型 0:用户,1:答复者
	 */
	public Integer getFromUser() {
		return this.fromUser;
	}

	/**
	 * 设置回复用户类型 0:用户,1:答复者
	 */
	public void setFromUser(Integer fromUser) {
		this.fromUser = fromUser;
	}

	/**
	 * 获取投诉问题id
	 */
	public BigInteger getQuestionId() {
		return this.questionId;
	}

	/**
	 * 设置投诉问题id
	 */
	public void setQuestionId(BigInteger questionId) {
		this.questionId = questionId;
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
	 * 获取回复评分
	 */
	public Integer getStar() {
		return this.star;
	}

	/**
	 * 设置回复评分
	 */
	public void setStar(Integer star) {
		this.star = star;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

package com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/;

import com.hpxs.base.BaseEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 实体bean
 * <p>
 * 表名：user_game
 * <p>
 * 描述：
 */
public class UserGame extends BaseEntity implements Serializable {
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
	private Integer userId;
	/**
	 * 
	 */
	private Integer gameId;

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
	public Integer getUserId() {
		return this.userId;
	}

	/**
	 * 设置
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 获取
	 */
	public Integer getGameId() {
		return this.gameId;
	}

	/**
	 * 设置
	 */
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

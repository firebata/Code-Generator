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
 * 表名：res_upload_image_file
 * <p>
 * 描述：
 */
public class ResUploadImageFile extends BaseEntity implements Serializable {
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
	 * 图片使用的业务类型 COMPLAINT("/resource/complaint", "资源封面图"), CUSTOMER_HEAD_IMG("/resource/customer/head_img", "用户头像")
	 */
	private String businessType;
	/**
	 * 文件名
	 */
	private String fileName;
	/**
	 * 源文件文件名
	 */
	private String originFileName;
	/**
	 * 文件路径 (可用于记录的唯一标识)
	 */
	private String path;
	/**
	 * 文件大小
	 */
	private Integer size;
	/**
	 * 用户 id
	 */
	private BigInteger userInfoId;

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
	 * 获取图片使用的业务类型 COMPLAINT("/resource/complaint", "资源封面图"), CUSTOMER_HEAD_IMG("/resource/customer/head_img", "用户头像")
	 */
	public String getBusinessType() {
		return this.businessType;
	}

	/**
	 * 设置图片使用的业务类型 COMPLAINT("/resource/complaint", "资源封面图"), CUSTOMER_HEAD_IMG("/resource/customer/head_img", "用户头像")
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	/**
	 * 获取文件名
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * 设置文件名
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 获取源文件文件名
	 */
	public String getOriginFileName() {
		return this.originFileName;
	}

	/**
	 * 设置源文件文件名
	 */
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}

	/**
	 * 获取文件路径 (可用于记录的唯一标识)
	 */
	public String getPath() {
		return this.path;
	}

	/**
	 * 设置文件路径 (可用于记录的唯一标识)
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * 获取文件大小
	 */
	public Integer getSize() {
		return this.size;
	}

	/**
	 * 设置文件大小
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * 获取用户 id
	 */
	public BigInteger getUserInfoId() {
		return this.userInfoId;
	}

	/**
	 * 设置用户 id
	 */
	public void setUserInfoId(BigInteger userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

package com.zlinks.domain/;

import com.hpxs.base.BaseEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.math.BigInteger;

/**
 * 实体bean
 * <p>
 * 表名：appsflyer_information
 * <p>
 * 描述：
 */
public class AppsflyerInformation extends BaseEntity implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private BigInteger id;
	/**
	 * 下载时间
	 */
	private String downloadTime;
	/**
	 * 安装时间
	 */
	private String installTime;
	/**
	 * 事件时间
	 */
	private String eventTime;
	/**
	 * 
	 */
	private String imei;
	/**
	 * 
	 */
	private String idfa;
	/**
	 * 渠道
	 */
	private String mediaSource;
	/**
	 * 广告ID
	 */
	private String campaign;
	/**
	 * 平台
	 */
	private String platform;
	/**
	 * 
	 */
	private String appsflyerDeviceId;
	/**
	 * 游戏ID
	 */
	private String appId;
	/**
	 * 事件名称
	 */
	private String eventName;
	/**
	 * 事件类型
	 */
	private String eventType;
	/**
	 * 
	 */
	private String siteId;
	/**
	 * 手机型号
	 */
	private String deviceModel;
	/**
	 * 手机品牌
	 */
	private String deviceBrand;
	/**
	 * 电信频段
	 */
	private String operator;
	/**
	 * 是否wifi
	 */
	private String wifi;
	/**
	 * IP
	 */
	private String ip;
	/**
	 * 国家代码
	 */
	private String countryCode;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 进入类型
	 */
	private String attributedTouchType;
	/**
	 * 所选币种
	 */
	private String selectedCurrency;
	/**
	 * 花费
	 */
	private String afCostValue;
	/**
	 * 税后
	 */
	private String revenueInSelectedCurrency;
	/**
	 * 
	 */
	private String attributionType;

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
	 * 获取下载时间
	 */
	public String getDownloadTime() {
		return this.downloadTime;
	}

	/**
	 * 设置下载时间
	 */
	public void setDownloadTime(String downloadTime) {
		this.downloadTime = downloadTime;
	}

	/**
	 * 获取安装时间
	 */
	public String getInstallTime() {
		return this.installTime;
	}

	/**
	 * 设置安装时间
	 */
	public void setInstallTime(String installTime) {
		this.installTime = installTime;
	}

	/**
	 * 获取事件时间
	 */
	public String getEventTime() {
		return this.eventTime;
	}

	/**
	 * 设置事件时间
	 */
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	/**
	 * 获取
	 */
	public String getImei() {
		return this.imei;
	}

	/**
	 * 设置
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}

	/**
	 * 获取
	 */
	public String getIdfa() {
		return this.idfa;
	}

	/**
	 * 设置
	 */
	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}

	/**
	 * 获取渠道
	 */
	public String getMediaSource() {
		return this.mediaSource;
	}

	/**
	 * 设置渠道
	 */
	public void setMediaSource(String mediaSource) {
		this.mediaSource = mediaSource;
	}

	/**
	 * 获取广告ID
	 */
	public String getCampaign() {
		return this.campaign;
	}

	/**
	 * 设置广告ID
	 */
	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}

	/**
	 * 获取平台
	 */
	public String getPlatform() {
		return this.platform;
	}

	/**
	 * 设置平台
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * 获取
	 */
	public String getAppsflyerDeviceId() {
		return this.appsflyerDeviceId;
	}

	/**
	 * 设置
	 */
	public void setAppsflyerDeviceId(String appsflyerDeviceId) {
		this.appsflyerDeviceId = appsflyerDeviceId;
	}

	/**
	 * 获取游戏ID
	 */
	public String getAppId() {
		return this.appId;
	}

	/**
	 * 设置游戏ID
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * 获取事件名称
	 */
	public String getEventName() {
		return this.eventName;
	}

	/**
	 * 设置事件名称
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * 获取事件类型
	 */
	public String getEventType() {
		return this.eventType;
	}

	/**
	 * 设置事件类型
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * 获取
	 */
	public String getSiteId() {
		return this.siteId;
	}

	/**
	 * 设置
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	/**
	 * 获取手机型号
	 */
	public String getDeviceModel() {
		return this.deviceModel;
	}

	/**
	 * 设置手机型号
	 */
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	/**
	 * 获取手机品牌
	 */
	public String getDeviceBrand() {
		return this.deviceBrand;
	}

	/**
	 * 设置手机品牌
	 */
	public void setDeviceBrand(String deviceBrand) {
		this.deviceBrand = deviceBrand;
	}

	/**
	 * 获取电信频段
	 */
	public String getOperator() {
		return this.operator;
	}

	/**
	 * 设置电信频段
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * 获取是否wifi
	 */
	public String getWifi() {
		return this.wifi;
	}

	/**
	 * 设置是否wifi
	 */
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	/**
	 * 获取IP
	 */
	public String getIp() {
		return this.ip;
	}

	/**
	 * 设置IP
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 获取国家代码
	 */
	public String getCountryCode() {
		return this.countryCode;
	}

	/**
	 * 设置国家代码
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * 获取城市
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * 设置城市
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 获取进入类型
	 */
	public String getAttributedTouchType() {
		return this.attributedTouchType;
	}

	/**
	 * 设置进入类型
	 */
	public void setAttributedTouchType(String attributedTouchType) {
		this.attributedTouchType = attributedTouchType;
	}

	/**
	 * 获取所选币种
	 */
	public String getSelectedCurrency() {
		return this.selectedCurrency;
	}

	/**
	 * 设置所选币种
	 */
	public void setSelectedCurrency(String selectedCurrency) {
		this.selectedCurrency = selectedCurrency;
	}

	/**
	 * 获取花费
	 */
	public String getAfCostValue() {
		return this.afCostValue;
	}

	/**
	 * 设置花费
	 */
	public void setAfCostValue(String afCostValue) {
		this.afCostValue = afCostValue;
	}

	/**
	 * 获取税后
	 */
	public String getRevenueInSelectedCurrency() {
		return this.revenueInSelectedCurrency;
	}

	/**
	 * 设置税后
	 */
	public void setRevenueInSelectedCurrency(String revenueInSelectedCurrency) {
		this.revenueInSelectedCurrency = revenueInSelectedCurrency;
	}

	/**
	 * 获取
	 */
	public String getAttributionType() {
		return this.attributionType;
	}

	/**
	 * 设置
	 */
	public void setAttributionType(String attributionType) {
		this.attributionType = attributionType;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

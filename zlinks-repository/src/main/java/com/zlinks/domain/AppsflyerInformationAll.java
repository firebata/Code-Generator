package com.zlinks.zlinks-repository/src/main/java/com/zlinks/domain/;

import com.hpxs.base.BaseEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.math.BigInteger;
import java.util.Date;

/**
 * 实体bean
 * <p>
 * 表名：appsflyer_information_all
 * <p>
 * 描述：
 */
public class AppsflyerInformationAll extends BaseEntity implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private BigInteger id;
	/**
	 * 
	 */
	private String attributedTouchType;
	/**
	 * 
	 */
	private String attributedTouchTime;
	/**
	 * 
	 */
	private String eventType;
	/**
	 * 
	 */
	private String attributionType;
	/**
	 * 
	 */
	private String clickTime;
	/**
	 * 
	 */
	private String downloadTime;
	/**
	 * 
	 */
	private String installTime;
	/**
	 * 
	 */
	private String mediaSource;
	/**
	 * 
	 */
	private String agency;
	/**
	 * 
	 */
	private String afChannel;
	/**
	 * 
	 */
	private String afKeywords;
	/**
	 * 
	 */
	private String campaign;
	/**
	 * 
	 */
	private String afCId;
	/**
	 * 
	 */
	private String afAdset;
	/**
	 * 
	 */
	private String afAdsetId;
	/**
	 * 
	 */
	private String afAd;
	/**
	 * 
	 */
	private String afAdId;
	/**
	 * 
	 */
	private String fbCampaignName;
	/**
	 * 
	 */
	private String fbCampaignId;
	/**
	 * 
	 */
	private String fbAdsetName;
	/**
	 * 
	 */
	private String fbAdsetId;
	/**
	 * 
	 */
	private String fbAdgroupName;
	/**
	 * 
	 */
	private String fbAdgroupId;
	/**
	 * 
	 */
	private String afAdType;
	/**
	 * 
	 */
	private String afSiteid;
	/**
	 * 
	 */
	private String afSub1;
	/**
	 * 
	 */
	private String afSub2;
	/**
	 * 
	 */
	private String afSub3;
	/**
	 * 
	 */
	private String afSub4;
	/**
	 * 
	 */
	private String afSub5;
	/**
	 * 
	 */
	private String httpReferrer;
	/**
	 * 
	 */
	private String clickUrl;
	/**
	 * 
	 */
	private String afCostModel;
	/**
	 * 
	 */
	private String afCostValue;
	/**
	 * 
	 */
	private String afCostCurrency;
	/**
	 * 
	 */
	private String costPerInstall;
	/**
	 * 
	 */
	private String isRetargeting;
	/**
	 * 
	 */
	private String reTargetingConversionType;
	/**
	 * 
	 */
	private String countryCode;
	/**
	 * 
	 */
	private String city;
	/**
	 * 
	 */
	private String ip;
	/**
	 * 
	 */
	private String wifi;
	/**
	 * 
	 */
	private String mac;
	/**
	 * 
	 */
	private String operator;
	/**
	 * 
	 */
	private String carrier;
	/**
	 * 
	 */
	private String language;
	/**
	 * 
	 */
	private String appsflyerDeviceId;
	/**
	 * 
	 */
	private String advertisingId;
	/**
	 * 
	 */
	private String androidId;
	/**
	 * 
	 */
	private String customerUserId;
	/**
	 * 
	 */
	private String imei;
	/**
	 * 
	 */
	private String idfa;
	/**
	 * 
	 */
	private String platform;
	/**
	 * 
	 */
	private String deviceBrand;
	/**
	 * 
	 */
	private String deviceModel;
	/**
	 * 
	 */
	private String osVersion;
	/**
	 * 
	 */
	private String appVersion;
	/**
	 * 
	 */
	private String sdkVersion;
	/**
	 * 
	 */
	private String appId;
	/**
	 * 
	 */
	private String appName;
	/**
	 * 
	 */
	private String bundleId;
	/**
	 * 
	 */
	private String eventTime;
	/**
	 * 
	 */
	private String eventName;
	/**
	 * 
	 */
	private String eventValue;
	/**
	 * 
	 */
	private String currency;
	/**
	 * 
	 */
	private String downloadTimeSelectedTimezone;
	/**
	 * 
	 */
	private String clickTimeSelectedTimezone;
	/**
	 * 
	 */
	private String installTimeSelectedTimezone;
	/**
	 * 
	 */
	private String eventTimeSelectedTimezone;
	/**
	 * 
	 */
	private String selectedCurrency;
	/**
	 * 
	 */
	private String revenueInSelectedCurrency;
	/**
	 * 
	 */
	private String costInSelectedCurrency;
	/**
	 * 
	 */
	private String deviceName;
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
	 * 
	 */
	private String afcid;

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
	 * 获取
	 */
	public String getAttributedTouchType() {
		return this.attributedTouchType;
	}

	/**
	 * 设置
	 */
	public void setAttributedTouchType(String attributedTouchType) {
		this.attributedTouchType = attributedTouchType;
	}

	/**
	 * 获取
	 */
	public String getAttributedTouchTime() {
		return this.attributedTouchTime;
	}

	/**
	 * 设置
	 */
	public void setAttributedTouchTime(String attributedTouchTime) {
		this.attributedTouchTime = attributedTouchTime;
	}

	/**
	 * 获取
	 */
	public String getEventType() {
		return this.eventType;
	}

	/**
	 * 设置
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
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

	/**
	 * 获取
	 */
	public String getClickTime() {
		return this.clickTime;
	}

	/**
	 * 设置
	 */
	public void setClickTime(String clickTime) {
		this.clickTime = clickTime;
	}

	/**
	 * 获取
	 */
	public String getDownloadTime() {
		return this.downloadTime;
	}

	/**
	 * 设置
	 */
	public void setDownloadTime(String downloadTime) {
		this.downloadTime = downloadTime;
	}

	/**
	 * 获取
	 */
	public String getInstallTime() {
		return this.installTime;
	}

	/**
	 * 设置
	 */
	public void setInstallTime(String installTime) {
		this.installTime = installTime;
	}

	/**
	 * 获取
	 */
	public String getMediaSource() {
		return this.mediaSource;
	}

	/**
	 * 设置
	 */
	public void setMediaSource(String mediaSource) {
		this.mediaSource = mediaSource;
	}

	/**
	 * 获取
	 */
	public String getAgency() {
		return this.agency;
	}

	/**
	 * 设置
	 */
	public void setAgency(String agency) {
		this.agency = agency;
	}

	/**
	 * 获取
	 */
	public String getAfChannel() {
		return this.afChannel;
	}

	/**
	 * 设置
	 */
	public void setAfChannel(String afChannel) {
		this.afChannel = afChannel;
	}

	/**
	 * 获取
	 */
	public String getAfKeywords() {
		return this.afKeywords;
	}

	/**
	 * 设置
	 */
	public void setAfKeywords(String afKeywords) {
		this.afKeywords = afKeywords;
	}

	/**
	 * 获取
	 */
	public String getCampaign() {
		return this.campaign;
	}

	/**
	 * 设置
	 */
	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}

	/**
	 * 获取
	 */
	public String getAfCId() {
		return this.afCId;
	}

	/**
	 * 设置
	 */
	public void setAfCId(String afCId) {
		this.afCId = afCId;
	}

	/**
	 * 获取
	 */
	public String getAfAdset() {
		return this.afAdset;
	}

	/**
	 * 设置
	 */
	public void setAfAdset(String afAdset) {
		this.afAdset = afAdset;
	}

	/**
	 * 获取
	 */
	public String getAfAdsetId() {
		return this.afAdsetId;
	}

	/**
	 * 设置
	 */
	public void setAfAdsetId(String afAdsetId) {
		this.afAdsetId = afAdsetId;
	}

	/**
	 * 获取
	 */
	public String getAfAd() {
		return this.afAd;
	}

	/**
	 * 设置
	 */
	public void setAfAd(String afAd) {
		this.afAd = afAd;
	}

	/**
	 * 获取
	 */
	public String getAfAdId() {
		return this.afAdId;
	}

	/**
	 * 设置
	 */
	public void setAfAdId(String afAdId) {
		this.afAdId = afAdId;
	}

	/**
	 * 获取
	 */
	public String getFbCampaignName() {
		return this.fbCampaignName;
	}

	/**
	 * 设置
	 */
	public void setFbCampaignName(String fbCampaignName) {
		this.fbCampaignName = fbCampaignName;
	}

	/**
	 * 获取
	 */
	public String getFbCampaignId() {
		return this.fbCampaignId;
	}

	/**
	 * 设置
	 */
	public void setFbCampaignId(String fbCampaignId) {
		this.fbCampaignId = fbCampaignId;
	}

	/**
	 * 获取
	 */
	public String getFbAdsetName() {
		return this.fbAdsetName;
	}

	/**
	 * 设置
	 */
	public void setFbAdsetName(String fbAdsetName) {
		this.fbAdsetName = fbAdsetName;
	}

	/**
	 * 获取
	 */
	public String getFbAdsetId() {
		return this.fbAdsetId;
	}

	/**
	 * 设置
	 */
	public void setFbAdsetId(String fbAdsetId) {
		this.fbAdsetId = fbAdsetId;
	}

	/**
	 * 获取
	 */
	public String getFbAdgroupName() {
		return this.fbAdgroupName;
	}

	/**
	 * 设置
	 */
	public void setFbAdgroupName(String fbAdgroupName) {
		this.fbAdgroupName = fbAdgroupName;
	}

	/**
	 * 获取
	 */
	public String getFbAdgroupId() {
		return this.fbAdgroupId;
	}

	/**
	 * 设置
	 */
	public void setFbAdgroupId(String fbAdgroupId) {
		this.fbAdgroupId = fbAdgroupId;
	}

	/**
	 * 获取
	 */
	public String getAfAdType() {
		return this.afAdType;
	}

	/**
	 * 设置
	 */
	public void setAfAdType(String afAdType) {
		this.afAdType = afAdType;
	}

	/**
	 * 获取
	 */
	public String getAfSiteid() {
		return this.afSiteid;
	}

	/**
	 * 设置
	 */
	public void setAfSiteid(String afSiteid) {
		this.afSiteid = afSiteid;
	}

	/**
	 * 获取
	 */
	public String getAfSub1() {
		return this.afSub1;
	}

	/**
	 * 设置
	 */
	public void setAfSub1(String afSub1) {
		this.afSub1 = afSub1;
	}

	/**
	 * 获取
	 */
	public String getAfSub2() {
		return this.afSub2;
	}

	/**
	 * 设置
	 */
	public void setAfSub2(String afSub2) {
		this.afSub2 = afSub2;
	}

	/**
	 * 获取
	 */
	public String getAfSub3() {
		return this.afSub3;
	}

	/**
	 * 设置
	 */
	public void setAfSub3(String afSub3) {
		this.afSub3 = afSub3;
	}

	/**
	 * 获取
	 */
	public String getAfSub4() {
		return this.afSub4;
	}

	/**
	 * 设置
	 */
	public void setAfSub4(String afSub4) {
		this.afSub4 = afSub4;
	}

	/**
	 * 获取
	 */
	public String getAfSub5() {
		return this.afSub5;
	}

	/**
	 * 设置
	 */
	public void setAfSub5(String afSub5) {
		this.afSub5 = afSub5;
	}

	/**
	 * 获取
	 */
	public String getHttpReferrer() {
		return this.httpReferrer;
	}

	/**
	 * 设置
	 */
	public void setHttpReferrer(String httpReferrer) {
		this.httpReferrer = httpReferrer;
	}

	/**
	 * 获取
	 */
	public String getClickUrl() {
		return this.clickUrl;
	}

	/**
	 * 设置
	 */
	public void setClickUrl(String clickUrl) {
		this.clickUrl = clickUrl;
	}

	/**
	 * 获取
	 */
	public String getAfCostModel() {
		return this.afCostModel;
	}

	/**
	 * 设置
	 */
	public void setAfCostModel(String afCostModel) {
		this.afCostModel = afCostModel;
	}

	/**
	 * 获取
	 */
	public String getAfCostValue() {
		return this.afCostValue;
	}

	/**
	 * 设置
	 */
	public void setAfCostValue(String afCostValue) {
		this.afCostValue = afCostValue;
	}

	/**
	 * 获取
	 */
	public String getAfCostCurrency() {
		return this.afCostCurrency;
	}

	/**
	 * 设置
	 */
	public void setAfCostCurrency(String afCostCurrency) {
		this.afCostCurrency = afCostCurrency;
	}

	/**
	 * 获取
	 */
	public String getCostPerInstall() {
		return this.costPerInstall;
	}

	/**
	 * 设置
	 */
	public void setCostPerInstall(String costPerInstall) {
		this.costPerInstall = costPerInstall;
	}

	/**
	 * 获取
	 */
	public String getIsRetargeting() {
		return this.isRetargeting;
	}

	/**
	 * 设置
	 */
	public void setIsRetargeting(String isRetargeting) {
		this.isRetargeting = isRetargeting;
	}

	/**
	 * 获取
	 */
	public String getReTargetingConversionType() {
		return this.reTargetingConversionType;
	}

	/**
	 * 设置
	 */
	public void setReTargetingConversionType(String reTargetingConversionType) {
		this.reTargetingConversionType = reTargetingConversionType;
	}

	/**
	 * 获取
	 */
	public String getCountryCode() {
		return this.countryCode;
	}

	/**
	 * 设置
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * 获取
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * 设置
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 获取
	 */
	public String getIp() {
		return this.ip;
	}

	/**
	 * 设置
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 获取
	 */
	public String getWifi() {
		return this.wifi;
	}

	/**
	 * 设置
	 */
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	/**
	 * 获取
	 */
	public String getMac() {
		return this.mac;
	}

	/**
	 * 设置
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
	 * 获取
	 */
	public String getOperator() {
		return this.operator;
	}

	/**
	 * 设置
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * 获取
	 */
	public String getCarrier() {
		return this.carrier;
	}

	/**
	 * 设置
	 */
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	/**
	 * 获取
	 */
	public String getLanguage() {
		return this.language;
	}

	/**
	 * 设置
	 */
	public void setLanguage(String language) {
		this.language = language;
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
	 * 获取
	 */
	public String getAdvertisingId() {
		return this.advertisingId;
	}

	/**
	 * 设置
	 */
	public void setAdvertisingId(String advertisingId) {
		this.advertisingId = advertisingId;
	}

	/**
	 * 获取
	 */
	public String getAndroidId() {
		return this.androidId;
	}

	/**
	 * 设置
	 */
	public void setAndroidId(String androidId) {
		this.androidId = androidId;
	}

	/**
	 * 获取
	 */
	public String getCustomerUserId() {
		return this.customerUserId;
	}

	/**
	 * 设置
	 */
	public void setCustomerUserId(String customerUserId) {
		this.customerUserId = customerUserId;
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
	 * 获取
	 */
	public String getPlatform() {
		return this.platform;
	}

	/**
	 * 设置
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * 获取
	 */
	public String getDeviceBrand() {
		return this.deviceBrand;
	}

	/**
	 * 设置
	 */
	public void setDeviceBrand(String deviceBrand) {
		this.deviceBrand = deviceBrand;
	}

	/**
	 * 获取
	 */
	public String getDeviceModel() {
		return this.deviceModel;
	}

	/**
	 * 设置
	 */
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	/**
	 * 获取
	 */
	public String getOsVersion() {
		return this.osVersion;
	}

	/**
	 * 设置
	 */
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	/**
	 * 获取
	 */
	public String getAppVersion() {
		return this.appVersion;
	}

	/**
	 * 设置
	 */
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	/**
	 * 获取
	 */
	public String getSdkVersion() {
		return this.sdkVersion;
	}

	/**
	 * 设置
	 */
	public void setSdkVersion(String sdkVersion) {
		this.sdkVersion = sdkVersion;
	}

	/**
	 * 获取
	 */
	public String getAppId() {
		return this.appId;
	}

	/**
	 * 设置
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * 获取
	 */
	public String getAppName() {
		return this.appName;
	}

	/**
	 * 设置
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * 获取
	 */
	public String getBundleId() {
		return this.bundleId;
	}

	/**
	 * 设置
	 */
	public void setBundleId(String bundleId) {
		this.bundleId = bundleId;
	}

	/**
	 * 获取
	 */
	public String getEventTime() {
		return this.eventTime;
	}

	/**
	 * 设置
	 */
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	/**
	 * 获取
	 */
	public String getEventName() {
		return this.eventName;
	}

	/**
	 * 设置
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * 获取
	 */
	public String getEventValue() {
		return this.eventValue;
	}

	/**
	 * 设置
	 */
	public void setEventValue(String eventValue) {
		this.eventValue = eventValue;
	}

	/**
	 * 获取
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * 设置
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * 获取
	 */
	public String getDownloadTimeSelectedTimezone() {
		return this.downloadTimeSelectedTimezone;
	}

	/**
	 * 设置
	 */
	public void setDownloadTimeSelectedTimezone(String downloadTimeSelectedTimezone) {
		this.downloadTimeSelectedTimezone = downloadTimeSelectedTimezone;
	}

	/**
	 * 获取
	 */
	public String getClickTimeSelectedTimezone() {
		return this.clickTimeSelectedTimezone;
	}

	/**
	 * 设置
	 */
	public void setClickTimeSelectedTimezone(String clickTimeSelectedTimezone) {
		this.clickTimeSelectedTimezone = clickTimeSelectedTimezone;
	}

	/**
	 * 获取
	 */
	public String getInstallTimeSelectedTimezone() {
		return this.installTimeSelectedTimezone;
	}

	/**
	 * 设置
	 */
	public void setInstallTimeSelectedTimezone(String installTimeSelectedTimezone) {
		this.installTimeSelectedTimezone = installTimeSelectedTimezone;
	}

	/**
	 * 获取
	 */
	public String getEventTimeSelectedTimezone() {
		return this.eventTimeSelectedTimezone;
	}

	/**
	 * 设置
	 */
	public void setEventTimeSelectedTimezone(String eventTimeSelectedTimezone) {
		this.eventTimeSelectedTimezone = eventTimeSelectedTimezone;
	}

	/**
	 * 获取
	 */
	public String getSelectedCurrency() {
		return this.selectedCurrency;
	}

	/**
	 * 设置
	 */
	public void setSelectedCurrency(String selectedCurrency) {
		this.selectedCurrency = selectedCurrency;
	}

	/**
	 * 获取
	 */
	public String getRevenueInSelectedCurrency() {
		return this.revenueInSelectedCurrency;
	}

	/**
	 * 设置
	 */
	public void setRevenueInSelectedCurrency(String revenueInSelectedCurrency) {
		this.revenueInSelectedCurrency = revenueInSelectedCurrency;
	}

	/**
	 * 获取
	 */
	public String getCostInSelectedCurrency() {
		return this.costInSelectedCurrency;
	}

	/**
	 * 设置
	 */
	public void setCostInSelectedCurrency(String costInSelectedCurrency) {
		this.costInSelectedCurrency = costInSelectedCurrency;
	}

	/**
	 * 获取
	 */
	public String getDeviceName() {
		return this.deviceName;
	}

	/**
	 * 设置
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
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
	 * 获取
	 */
	public String getAfcid() {
		return this.afcid;
	}

	/**
	 * 设置
	 */
	public void setAfcid(String afcid) {
		this.afcid = afcid;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

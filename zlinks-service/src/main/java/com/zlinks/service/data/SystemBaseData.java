package com.zlinks.service.data;

import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author zhangjh
 */

public enum SystemBaseData {


    INSTANCE;


    public String whiteIpList;

    public String deviceList;

    public String verifyCodeConfig;


    public String getWhiteIpList(StringRedisTemplate stringRedisTemplate) {
        return whiteIpList;
    }

    public void setWhiteIpList(String whiteIpList) {
        this.whiteIpList = whiteIpList;
    }

    public String getDeviceList(StringRedisTemplate stringRedisTemplate) {
        return deviceList;
    }

    public void setDeviceList(String deviceList) {
        this.deviceList = deviceList;
    }

}

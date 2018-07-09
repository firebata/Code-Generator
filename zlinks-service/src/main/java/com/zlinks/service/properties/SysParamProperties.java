package com.zlinks.service.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author bruce
 * @Date 2018/1/4 10:46
 * @Company zlinks
 * 系统配置参数
 */
@Component
@ConfigurationProperties(prefix = "zlinks.sys.config")
public class SysParamProperties {

    private String whiteIpList;

    private String deviceList;

    public String getWhiteIpList() {
        return whiteIpList;
    }

    public void setWhiteIpList(String whiteIpList) {
        this.whiteIpList = whiteIpList;
    }

    public String getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(String deviceList) {
        this.deviceList = deviceList;
    }
}

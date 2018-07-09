package com.zlinks.service.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author bruce
 * @Date 2017/6/26 10:42
 * @Company zlinks
 * 邮件配置类
 */
@Component
@ConfigurationProperties(prefix = "zlinks.email")
public class EmailProperties {
    private String baseUrl;
    private String baseUrlTW;
    private String baseUrlKR;
    private String baseUrlUS;
    private String emailServer;
    private String emailAddress;
    private String emailPort;
    private String emailUsername;
    private String emailPassword;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrlTW() {
        return baseUrlTW;
    }

    public void setBaseUrlTW(String baseUrlTW) {
        this.baseUrlTW = baseUrlTW;
    }

    public String getBaseUrlKR() {
        return baseUrlKR;
    }

    public void setBaseUrlKR(String baseUrlKR) {
        this.baseUrlKR = baseUrlKR;
    }

    public String getBaseUrlUS() {
        return baseUrlUS;
    }

    public void setBaseUrlUS(String baseUrlUS) {
        this.baseUrlUS = baseUrlUS;
    }

    public String getEmailServer() {
        return emailServer;
    }

    public void setEmailServer(String emailServer) {
        this.emailServer = emailServer;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailPort() {
        return emailPort;
    }

    public void setEmailPort(String emailPort) {
        this.emailPort = emailPort;
    }

    public String getEmailUsername() {
        return emailUsername;
    }

    public void setEmailUsername(String emailUsername) {
        this.emailUsername = emailUsername;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }
}

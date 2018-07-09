package com.zlinks.common;

/**
 * Created by zhangjh on 2017/10/10.
 * 配置文件 读取类
 */
public class BaseProp {
    // 是否生成模式,服务启动时在bootstrapApi 里设值
    // DEV:开发环境 UAT PROD
    public String env = "local";

    public String aliyunOssEndpoint;

    public String aliyunOssBucketName;

    public String domainUploadsHttp;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getAliyunOssEndpoint() {
        return aliyunOssEndpoint;
    }

    public void setAliyunOssEndpoint(String aliyunOssEndpoint) {
        this.aliyunOssEndpoint = aliyunOssEndpoint;
    }

    public String getAliyunOssBucketName() {
        return aliyunOssBucketName;
    }

    public void setAliyunOssBucketName(String aliyunOssBucketName) {
        this.aliyunOssBucketName = aliyunOssBucketName;
    }

    public String getDomainUploadsHttp() {
        return domainUploadsHttp;
    }

    public void setDomainUploadsHttp(String domainUploadsHttp) {
        this.domainUploadsHttp = domainUploadsHttp;
    }
}

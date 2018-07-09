package com.zlinks.common;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Created by zhangjh on 2017/10/10.
 * 基础配置文件
 */
public class BaseConfig {
    // 系统各种环境
    String LOCAL = "local";
    String DEV = "dev";
    String UAT = "uat";
    String PROD = "prod";

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }
}

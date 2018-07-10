package com.zlinks;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * 启动类
 */
@SpringBootApplication
@EnableAutoConfiguration
public class BootstrapDemoApi {
    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(BootstrapDemoApi.class);
        app.setBannerMode(Banner.Mode.LOG);
        ApplicationContext applicationContext = app.run(args);
    }
}
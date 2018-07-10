package com.zlinks;

import com.zlinks.common.web.BWebMvcConfigurerAdapter;
import com.zlinks.intercepter.AccessLogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.annotation.Resource;

/**
 * @author : zhangjh on 2017.10.17
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends BWebMvcConfigurerAdapter {


    @Resource
    private AccessLogInterceptor accessLogInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        registry.addInterceptor(accessLogInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/*/bi/accounts/monitor/telnet/info")
                .excludePathPatterns("/error")
                .excludePathPatterns("/druid");


//        registry.addInterceptor(authInterceptor).addPathPatterns("/**")
//                .excludePathPatterns("/*/bi/accounts/monitor/telnet/info")
//                .excludePathPatterns("/error")
//                .excludePathPatterns("/*/bi/accounts/login")
//                .excludePathPatterns("/*/bi/accounts/register")
//                .excludePathPatterns("/*/bi/accounts/*")
//        ;


        super.addInterceptors(registry);
    }
}

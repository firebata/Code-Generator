package com.zlinks.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.zlinks.Routes;
import com.zlinks.common.DruidDataSourceProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableConfigurationProperties(DruidDataSourceProperties.class)
public class DruidDataSourceConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public ServletRegistrationBean druidServlet(DruidDataSourceProperties druidDataSourceProperties) {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings(Routes.API_VERSION + "/druid/*");
        reg.addInitParameter("loginUsername", "james");
        reg.addInitParameter("loginPassword", "james@zlinks.cn");
        reg.addInitParameter("logSlowSql", "true");
        return reg;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }

    @Bean
    public DataSource druidDataSource(DruidDataSourceProperties druidDataSourceProperties) {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(druidDataSourceProperties.getUrl());
        datasource.setUsername(druidDataSourceProperties.getUsername());
        datasource.setPassword(druidDataSourceProperties.getPassword());
        datasource.setDriverClassName(druidDataSourceProperties.getDriverClassName());
        datasource.setInitialSize(druidDataSourceProperties.getInitialSize());
        datasource.setMinIdle(druidDataSourceProperties.getMinIdle());
        datasource.setMaxActive(druidDataSourceProperties.getMaxActive());
        datasource.setMaxWait(druidDataSourceProperties.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(druidDataSourceProperties.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(druidDataSourceProperties.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(druidDataSourceProperties.getValidationQuery());
        datasource.setTestWhileIdle(druidDataSourceProperties.isTestWhileIdle());
        datasource.setTestOnBorrow(druidDataSourceProperties.isTestOnBorrow());
        datasource.setTestOnReturn(druidDataSourceProperties.isTestOnReturn());
        datasource.setConnectionProperties(druidDataSourceProperties.getConnectionProperties());
        try {
            datasource.setFilters(druidDataSourceProperties.getFilters());
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        return datasource;
    }

}

package com.zlinks.service.helper.game;

import com.zlinks.service.properties.SysParamProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zhangjh
 * @date 2017/11/1 17:11
 */
@Component
public class SystemBaseDataInitializationHelper {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private SysParamProperties paramProperties;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void initData() {

        logger.info("=====================>begin to init system base data");


        logger.info("======================>end init system base data");
    }
}

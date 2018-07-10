package com.zlinks.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangjh
 * @date 2017/10/28 11:19
 */
@Configuration
@ConditionalOnClass({RedisPoolConfig.class})
@Profile({"prod", "prod-kr", "prod-dhh-jp"})
public class RedisPoolConfig {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.redis.cluster.nodes}")
    private String nodes;

    @Value("${spring.redis.cluster.password}")
    private String password;

    @Value("${spring.redis.cluster.timeout}")
    private int timeout;

    @Value("${spring.redis.cluster.connectionTimeout}")
    private int connectionTimeout;

    @Value("${spring.redis.cluster.max-redirects}")
    private int maxRedirects;


    @Value("${spring.redis.cluster.maxTotal}")
    private int maxTotal;

    @Value("${spring.redis.cluster.maxIdle}")
    private int maxIdle;

    @Value("${spring.redis.cluster.minIdle}")
    private int minIdle;

    @Value("${spring.redis.cluster.maxWait}")
    private int maxWait;

    @Value("${spring.redis.cluster.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.redis.cluster.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.redis.cluster.maxAttempts}")
    private int maxAttempts;

    @Bean
    public RedisClusterConfiguration getClusterConfiguration() {
        String[] serverArray = nodes.split(",");
        Set<RedisNode> nodes = new HashSet<>();
        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new RedisNode(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
        redisClusterConfiguration.setClusterNodes(nodes);
        redisClusterConfiguration.setMaxRedirects(maxRedirects);
        redisClusterConfiguration.setPassword(RedisPassword.of(password));
        return redisClusterConfiguration;
    }


    @Bean
    public JedisConnectionFactory getConnectionFactory() {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(getClusterConfiguration());
        return connectionFactory;
    }

    @Bean
    public JedisPoolConfig getJedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMaxTotal(maxTotal);
        config.setTestOnBorrow(testOnBorrow);
        config.setTestOnReturn(testOnReturn);
        config.setMinIdle(minIdle);
        return config;
    }

}

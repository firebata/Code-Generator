package com.zlinks.common.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangjh
 * @date 2017/10/31 19:56
 */
public enum RedisHelper {

    INSTANCE;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ReentrantLock lockOne = new ReentrantLock();

    private ReentrantLock lockTwo = new ReentrantLock();

    /**
     * list弹出
     *
     * @param stringRedisTemplate
     * @param keyName
     * @return
     */
    public String leftPop(StringRedisTemplate stringRedisTemplate, String keyName) {
        String orderNum = null;
        try {
            lockOne.lock();
            BoundListOperations<String, String> listRedisTemplate = stringRedisTemplate.boundListOps(keyName);
            Object result = listRedisTemplate.leftPop();
            if (null != result) {
                orderNum = result.toString();
            }
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        } finally {
            lockOne.unlock();
        }
        return orderNum;

    }


    /**
     * set弹出
     *
     * @param stringRedisTemplate
     * @param keyName
     * @return
     */
    public String pop(StringRedisTemplate stringRedisTemplate, String keyName) {
        String orderNum = null;
        try {

//            lockTwo.lock();

            BoundSetOperations<String, String> listRedisTemplate = stringRedisTemplate.boundSetOps(keyName);

            Object result = listRedisTemplate.pop();
            if (null != result) {
                orderNum = result.toString();
            }
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        } finally {
//            lockTwo.unlock();
        }
        return orderNum;
    }


    /**
     * @param stringRedisTemplate
     * @param key
     */
    public void delete(StringRedisTemplate stringRedisTemplate, String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * @param stringRedisTemplate
     * @param key
     * @param delta
     * @return
     */
    public Long increment(StringRedisTemplate stringRedisTemplate, String key, long delta) {
        return stringRedisTemplate.boundValueOps(key).increment(delta);
    }

    /**
     * 获取分布式锁
     *
     * @param stringRedisTemplate
     * @param key
     * @return
     */
    public Boolean getLock(StringRedisTemplate stringRedisTemplate, String key) {
        byte[] bytes = new byte[0];
        RedisConnection connection = stringRedisTemplate.getConnectionFactory().getConnection();
        Boolean aBoolean;
        try {
            aBoolean = connection.setNX(key.getBytes(), bytes);
            if (aBoolean){
                stringRedisTemplate.boundHashOps(key).expire(10L, TimeUnit.SECONDS);
            }
        } finally {
            if (null != connection) {
                connection.close();
            }
        }

        return aBoolean;
    }


    public void lock(StringRedisTemplate stringRedisTemplate, String key, long timeout) {
        String lockKey = generateLockKey(key);
        long start = System.currentTimeMillis();
        try {
            while ((System.currentTimeMillis() - start) < timeout) {
                byte[] bytes = new byte[0];
                if (stringRedisTemplate.getConnectionFactory().getConnection().setNX(lockKey.getBytes(), bytes)) {
                    stringRedisTemplate.expire(lockKey, DEFAULT_EXPIRE, TimeUnit.SECONDS);
                    if (logger.isDebugEnabled()) {
                        logger.debug("add RedisLock[" + key + "].");
                    }
                    break;
                }
                TimeUnit.SECONDS.sleep(3);
            }
        } catch (Exception e) {
            unlock(stringRedisTemplate, lockKey);
        }
    }

    /**
     * @param stringRedisTemplate
     * @param key
     */
    public void unlock(StringRedisTemplate stringRedisTemplate, String key) {
        String lockKey = generateLockKey(key);
        if (logger.isDebugEnabled()) {
            logger.debug("release RedisLock[" + lockKey + "].");
        }
        RedisConnection connection = stringRedisTemplate.getConnectionFactory().getConnection();
        try {
            connection.del(lockKey.getBytes());
        } finally {
            if (null != connection) {
                connection.close();
            }
        }
    }


    /**
     * @param key
     * @return
     */
    private String generateLockKey(String key) {
        return String.format("LOCK:%s", key);
    }

    /**
     * @param stringRedisTemplate
     * @param key
     */
    public void lock(StringRedisTemplate stringRedisTemplate, String key) {
        lock(stringRedisTemplate, key, DEFAULT_WAIT_LOCK_TIME_OUT);
    }

    //10s 有慢sql，超时时间设置长一点
    private static final long DEFAULT_WAIT_LOCK_TIME_OUT = 10L;

    //2s 有慢sql，超时时间设置长一点
    private static final long DEFAULT_EXPIRE = 2L;

}

package com.redis.operation.application.distributedLock.Manager.Impl;

import com.redis.operation.application.distributedLock.Manager.DistributedLockManager;
import com.redis.operation.basic.ServiceRedis;
import com.redis.operation.common.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author：tanxiong
 * @Description：
 * @Date： 2020/6/5
 */
@Service
public class DistributedLockManagerImpl extends ServiceRedis implements DistributedLockManager {

    private final static Logger logger= LoggerFactory.getLogger(DistributedLockManagerImpl.class);

    private static String LOCK_PREFIX = "lock_";
    private static String lockPath = "Get_Lock.lua";
    private static String unlockPath = "UN_Lock.lua";

    @Override
    public void getLocak(String key, String value) {
        try {
            Boolean flag = RedisUtils.lock(redisTemplate, LOCK_PREFIX + key, value, lockPath);
            if(flag){
                logger.info("获取锁成功");
            }
        } catch (IOException e) {
            logger.error("加锁异常:===>{}",e);
        }
        return ;
    }

    @Override
    public void unLocak(String key, String value) {
        try {
            Boolean flag = RedisUtils.lock(redisTemplate, LOCK_PREFIX + key, value, unlockPath);
            if(flag){
                logger.info("释放锁成功");
            }
        } catch (IOException e) {
            logger.info("释放锁异常===>{}",e);
        }
    }
}

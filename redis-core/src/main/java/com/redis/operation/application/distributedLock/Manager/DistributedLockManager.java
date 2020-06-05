package com.redis.operation.application.distributedLock.Manager;

/**
 * @Author：tanxiong
 * @Description：
 * @Date： 2020/6/5
 */
public interface DistributedLockManager {
    /**
     * 加锁
     * @param key
     * @param value
     * @return
     */
    void getLocak(String key, String value);

    /**
     * 释放锁
     * @param key
     * @param value
     */
    void unLocak(String key, String value);
}

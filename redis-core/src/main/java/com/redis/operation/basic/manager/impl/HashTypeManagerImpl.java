package com.redis.operation.basic.manager.impl;

import com.redis.operation.basic.ServiceRedis;
import com.redis.operation.basic.manager.HashTypeManager;

import java.util.Map;

/**
 * @Author：tanxiong
 * @Description： Hash
 * @Date： 2020/6/4
 */
public class HashTypeManagerImpl extends ServiceRedis implements HashTypeManager {
    @Override
    public void save(String key, Object field, Object obj) {
        redisTemplate.opsForHash().put(key,field,obj);
    }

    @Override
    public Long hLen(String key, Object field) {
        return redisTemplate.opsForHash().lengthOfValue(key,field);
    }

    @Override
    public Object hGet(String key, Object field) {

        return redisTemplate.opsForHash().get(key,field);
    }

    @Override
    public void saveAll(String key, Map<?,?> map) {
        redisTemplate.opsForHash().putAll(key,map);
    }


    @Override
    public boolean expira(String key, long time) {
        return false;
    }

    @Override
    public void del(String... key) {

    }
}

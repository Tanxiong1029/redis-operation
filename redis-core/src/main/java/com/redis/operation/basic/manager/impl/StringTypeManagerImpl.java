package com.redis.operation.basic.manager.impl;

import com.redis.operation.basic.ServiceRedis;
import com.redis.operation.basic.manager.StringTypeManager;
import com.redis.operation.common.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @Author：tanxiong
 * @Description： String
 * @Date： 2020/6/3
 */

@Service
public class StringTypeManagerImpl extends ServiceRedis implements StringTypeManager {

    private static final Logger logger = LoggerFactory.getLogger(StringTypeManagerImpl.class);


    @Override
    public void save(String key, Object obj) {
        if (StringUtils.isNotBlank(key)) {
            redisTemplate.opsForValue().set(key, obj);
        }
    }



    @Override
    public boolean expira(String key,long time) {
        return RedisUtils.expira(redisTemplate,key,time);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void del(String... key) {
        RedisUtils.del(redisTemplate,key);
    }

    @Override
    public void batchSave(Map<? extends String, Object> map) {
        redisTemplate.opsForValue().multiSet(map);
    }

    @Override
    public List batchGet(String... key) {
        return redisTemplate.opsForValue().multiGet(CollectionUtils.arrayToList(key));
    }

    @Override
    public void incr(String key) {
        redisTemplate.opsForValue().increment(key);
    }

    @Override
    public void incr(String key, double count) {
        redisTemplate.opsForValue().increment(key,count);
    }

    @Override
    public void incr(String key, long count) {
        redisTemplate.opsForValue().increment(key,count);
    }
}

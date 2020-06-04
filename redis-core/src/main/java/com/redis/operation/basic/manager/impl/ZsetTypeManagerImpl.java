package com.redis.operation.basic.manager.impl;

import com.redis.operation.basic.ServiceRedis;
import com.redis.operation.basic.manager.ZsetTypeManager;
import com.redis.operation.common.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author：tanxiong
 * @Description： ZSet
 * @Date： 2020/6/4
 */
@Service
public class ZsetTypeManagerImpl extends ServiceRedis implements ZsetTypeManager {

    private static final Logger logger = LoggerFactory.getLogger(ZsetTypeManagerImpl.class);


    @Override
    public boolean save(String key,Object obj, double score) {
        Boolean flag=false;
        try {
            flag= redisTemplate.opsForZSet().add(key, obj, score);
        } catch (Exception e) {
            logger.error("zset key to redis error:===>{}",e);
        }
        return flag;
    }

    @Override
    public boolean expira(String key, long time) {
        Boolean flag=false;
        try {
            flag= RedisUtils.expira(redisTemplate,key,time);
        } catch (Exception e) {
            logger.error("set key expiration time s error:===>{}",e);
        }
        return flag;
    }

    @Override
    public Set<Object> rangeByScore(String key,long start,long end) {
        return redisTemplate.opsForZSet().rangeByScore(key, start, end);
    }

    @Override
    public Set<Object> range(String key, long start, long end) {
        return redisTemplate.opsForZSet().range(key,start,end);
    }

    @Override
    public Long rank(String key, Object obj) {
        return redisTemplate.opsForZSet().rank(key,obj);
    }

    @Override
    public Long remove(String key, Object... obj) {
        return redisTemplate.opsForZSet().remove(key,obj);
    }

    @Override
    public void del(String... key) {

    }
}

package com.redis.operation.basic.manager.impl;

import com.redis.operation.basic.ServiceRedis;
import com.redis.operation.basic.manager.ListTypeManager;
import com.redis.operation.common.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author：tanxiong
 * @Description： List
 * @Date： 2020/6/4
 */
@Service
public class ListTypeManagerImpl extends ServiceRedis implements ListTypeManager {

    private final static Logger logger = LoggerFactory.getLogger(ListTypeManagerImpl.class);

    @Override
    public void save(String key, Object obj, boolean flag) {
        //flag=true 左进右出
        if (flag) {
            redisTemplate.opsForList().leftPush(key, obj);
        } else {
            //flag=true 右进左出
            redisTemplate.opsForList().rightPush(key, obj);
        }

    }

    @Override
    public boolean expira(String key, long time) {
        boolean flag = false;
        try {
            flag = RedisUtils.expira(redisTemplate, key, time);
        } catch (Exception e) {
            logger.error("set expiration time error:===>{}", e);
        }
        return flag;
    }

    @Override
    public Object get(String key, boolean flag) {
        Object obj=null;
        if(flag){
            obj= redisTemplate.opsForList().rightPop(key);
        }else{
            obj=redisTemplate.opsForList().leftPop(key);
        }
        return obj;
    }

    @Override
    public void del(String... key) {
        RedisUtils.del(redisTemplate,key);
    }

    @Override
    public Object lrang(String key, long startIndex, long endIndex) {
        return redisTemplate.opsForList().range(key,startIndex,endIndex);
    }

    @Override
    public Long llen(String key) {
        return redisTemplate.opsForList().size(key);
    }

    @Override
    public Object lindex(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    @Override
    public void ltrim(String key, long startIndex, long endIndex) {
        redisTemplate.opsForList().trim(key,startIndex,endIndex);
    }
}

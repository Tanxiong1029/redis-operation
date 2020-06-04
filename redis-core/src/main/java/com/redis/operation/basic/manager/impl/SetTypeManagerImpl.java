package com.redis.operation.basic.manager.impl;

import com.redis.operation.basic.ServiceRedis;
import com.redis.operation.basic.manager.SetTypeManager;
import com.redis.operation.common.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author：tanxiong
 * @Description： set
 * @Date： 2020/6/4
 */

@Service
public class SetTypeManagerImpl extends ServiceRedis implements SetTypeManager {

    private final static Logger logger = LoggerFactory.getLogger(SetTypeManagerImpl.class);

    @Override
    public void save(String key, Object obj) {
        redisTemplate.opsForSet().add(key,obj);
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
    public Object get(String key) {
        return  redisTemplate.opsForSet().members(key);
    }

    @Override
    public void del(String... key) {
        RedisUtils.del(redisTemplate,key);
    }
}

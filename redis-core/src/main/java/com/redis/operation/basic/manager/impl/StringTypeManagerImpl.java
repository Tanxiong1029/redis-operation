package com.redis.operation.basic.manager.impl;

import com.redis.operation.basic.ServiceRedis;
import com.redis.operation.basic.manager.StringTypeManager;
import com.redis.operation.common.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author：tanxiong
 * @Description： String类型操作
 * @Date： 2020/6/3
 */

@Service
public class StringTypeManagerImpl extends ServiceRedis implements StringTypeManager {

    private static final Logger logger = LoggerFactory.getLogger(StringTypeManagerImpl.class);

    @Override
    public void save(String key, String value) {
        if (StringUtils.isNotBlank(key)) {
            redisTemplate.opsForValue().set(key, value);
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
}

package com.redis.operation.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author：tanxiong
 * @Description：
 * @Date： 2020/6/3
 */
@Repository
public class ServiceRedis {

    @Autowired(required = false)
    @Qualifier("redisTemplate")
    protected RedisTemplate<String, Object> redisTemplate;

}

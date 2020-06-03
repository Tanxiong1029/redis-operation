package com.redis.operation.common;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Author：tanxiong
 * @Description：
 * @Date： 2020/6/3
 */
public class RedisUtils {

    private final static Logger logger= LoggerFactory.getLogger(RedisUtils.class);

    /**
     *  设置key过期时间
     * @param redisTemplate
     * @param key
     * @param time 时间(秒)
     * @return boolean
     */
    public static boolean expira(RedisTemplate<String, Object> redisTemplate,String key,long time){
        boolean flag=false;
        try {
            //注意过期时间不能超过Integer.MAX_VALUE,否则会抛出异常
            if(StringUtils.isNotBlank(key) && time>0){
                flag=redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            logger.error("set redis key expiration time error:===>{}",e);
        }
        return flag;
    }

    /**
     * 判断key是否存在
     * @param redisTemplate
     * @param key
     * @return true 存在 false 不存在
     */
    public static boolean hasKey(RedisTemplate<String, Object> redisTemplate,String key){
        boolean flag=false;
        try {
            if(StringUtils.isNotBlank(key)){
                flag=redisTemplate.hasKey(key);
            }
        } catch (Exception e) {
           logger.error("check whether the key exists error:===>{}",e);
        }
        return flag;
    }

    /**
     * 获取指定key的过期时间
     * @param redisTemplate
     * @param key
     * @return 时间(秒) 返回0代表为永久有效
     */
    public static long getExpira(RedisTemplate<String, Object> redisTemplate,String key){
        //key不能为空
        return redisTemplate.getExpire(key);
    }

    /**
     * 删除Redis中的key
     * @param redisTemplate
     * @param key
     */
    public static void del(RedisTemplate<String, Object> redisTemplate,String... key) {
        try {
            if (key != null && key.length > 0) {
                if (key.length == 1) {
                    redisTemplate.delete(key[0]);
                } else {
                     redisTemplate.delete(CollectionUtils.arrayToList(key));
                }
            }
        } catch (Exception e) {
          logger.error("delete redis key error:===>{}",e);
        }
    }

}

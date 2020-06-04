package com.redis.operation.basic.manager;

/**
 * @Author：tanxiong
 * @Description：
 * @Date： 2020/6/4
 */
public interface  TypeManager {

    /**
     * 设置key的过期时间
     * @param key
     * @param time
     * @return
     */
    boolean expira(String key,long time);

    /**
     * 批量删除
     * @param key
     */
    void del(String... key);
}

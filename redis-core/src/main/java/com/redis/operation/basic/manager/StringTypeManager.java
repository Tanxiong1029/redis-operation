package com.redis.operation.basic.manager;

/**
 * @Author：tanxiong
 * @Description：
 * @Date： 2020/6/3
 */
public interface StringTypeManager {
    void save(String key,String value);

    boolean expira(String key,long time);

    Object get(String key);

    void del(String... key);
}

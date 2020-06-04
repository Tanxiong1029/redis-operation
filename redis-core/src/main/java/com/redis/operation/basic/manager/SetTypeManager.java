package com.redis.operation.basic.manager;

/**
 * @Author：tanxiong
 * @Description：
 * @Date： 2020/6/4
 */
public interface SetTypeManager extends TypeManager {
    void save(String key, Object obj);

    Object get(String key);
}

package com.redis.operation.basic.manager;

import java.util.List;
import java.util.Map;

/**
 * @Author：tanxiong
 * @Description： String
 * @Date： 2020/6/3
 */
public interface StringTypeManager extends TypeManager {

    void save(String key, Object obj);

    Object get(String key);

    /**
     * 批量写入redis
     * @param map
     */
    void batchSave(Map<? extends String,Object> map);

    /**
     * 批量获取key-value
     * @param key
     * @return
     */
    List batchGet(String... key);

    /**
     * value(整数) 计数
     * @param key
     */
    void  incr(String key);

    /**
     * value(整数) 计数
     * @param key
     * @param count
     */
    void  incr(String key,double count);

    /**
     * value(整数) 计数
     * @param key
     * @param count
     */
    void  incr(String key,long count);
}

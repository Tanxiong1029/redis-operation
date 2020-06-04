package com.redis.operation.basic.manager;

/**
 * @Author：tanxiong
 * @Description：
 * @Date： 2020/6/4
 */
public interface ListTypeManager extends TypeManager{

    /**
     * 向redis写入
     * @param key
     * @param obj
     * @param flag
     */
    void save(String key,Object obj,boolean flag);


    /**
     * 从redis中取出单个key的值
     * @param key
     * @param flag
     * @return
     */
    Object get(String key,boolean flag);


    Object lrang(String key,long startIndex,long endIndex);

    Long llen(String key);

    Object lindex(String key,long index);

    void ltrim(String key,long startIndex,long endIndex);
}

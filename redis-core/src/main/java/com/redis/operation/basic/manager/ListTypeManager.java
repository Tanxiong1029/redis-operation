package com.redis.operation.basic.manager;

/**
 * @Author：tanxiong
 * @Description：
 * @Date： 2020/6/4
 */
public interface ListTypeManager extends TypeManager{

    Object lrang(String key,long startIndex,long endIndex);

    Long llen(String key);

    Object lindex(String key,long index);

    void ltrim(String key,long startIndex,long endIndex);
}

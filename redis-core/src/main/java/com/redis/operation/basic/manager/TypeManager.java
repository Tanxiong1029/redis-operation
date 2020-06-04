package com.redis.operation.basic.manager;

/**
 * @Author：tanxiong
 * @Description：
 * @Date： 2020/6/4
 */
public interface  TypeManager {
    /**
     * 向redis写入
     * @param key
     * @param value
     * @param flag
     */
    void save(String key,String value,boolean flag);

    /**
     * 设置key的过期时间
     * @param key
     * @param time
     * @return
     */
    boolean expira(String key,long time);

    /**
     * 从redis中取出单个key的值
     * @param key
     * @param flag
     * @return
     */
    Object get(String key,boolean flag);

    /**
     * 批量删除
     * @param key
     */
    void del(String... key);
}

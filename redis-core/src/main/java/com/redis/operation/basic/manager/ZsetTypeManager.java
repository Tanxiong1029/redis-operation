package com.redis.operation.basic.manager;

import java.util.Set;

/**
 * @Author：tanxiong
 * @Description：
 * @Date： 2020/6/4
 */
public interface ZsetTypeManager extends TypeManager {
    /**
     * 写入
     * @param key
     * @param obj
     * @param score
     */
    boolean save(String key,Object obj, double score);

    /**
     * 按score区间遍历
     * @param key
     * @param start
     * @param end
     * @return
     */
    Set<Object> rangeByScore(String key, long start, long end);

    Set<Object> range(String key, long start, long end);

    /**
     * 获取score值
     * @param key
     * @param obj
     * @return
     */
    Long rank(String key,Object obj);

    /**
     * 移除value值
     * @param key
     * @param obj
     * @return
     */
    Long remove(String key,Object...obj);
}

package com.redis.operation.basic.manager;

import java.util.Map;

/**
 * @Author：tanxiong
 * @Description：
 * @Date： 2020/6/4
 */
public interface HashTypeManager extends TypeManager {
    void save(String key,Object field,Object obj);

    Long hLen(String key,Object field);

    Object hGet(String key,Object field);

    void saveAll(String key, Map<?,?> map);


}

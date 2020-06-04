package com.redis.operation.controller;

import com.redis.operation.basic.manager.StringTypeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：tanxiong
 * @Description：
 * @Date： 2020/6/3
 */
@RestController
public class StringController {
    @Autowired
    private StringTypeManager stringTypeManager;

    @RequestMapping("/test")
    public void stringTest() {
        System.out.println("========================");
        String key="test";
        stringTypeManager.save(key, "test");
        stringTypeManager.expira(key,1000);
        System.out.println(stringTypeManager.get(key));
        stringTypeManager.del(key);
        System.out.println("+++++++++++++++++++++++++++");
        Map<String,Object> map=new HashMap<>();
        map.put(key+"0",1);
        map.put(key+"1",2);
        stringTypeManager.batchSave(map);
        System.out.println(stringTypeManager.batchGet(key+"0",key+"1"));
    }
}

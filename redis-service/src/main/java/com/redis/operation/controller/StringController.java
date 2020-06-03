package com.redis.operation.controller;

import com.redis.operation.basic.manager.StringTypeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        stringTypeManager.save("test", "test");
    }
}

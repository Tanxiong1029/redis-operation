package com.redis.operation;

import com.redis.operation.basic.manager.StringTypeManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@RunWith(SpringRunner.class)
@SpringBootTest
class RedisServiceApplicationTests {

    @Autowired
    private StringTypeManager stringTypeManager;

    @Test
    void contextLoads() {
        stringTypeManager.save("test","test");

    }



}

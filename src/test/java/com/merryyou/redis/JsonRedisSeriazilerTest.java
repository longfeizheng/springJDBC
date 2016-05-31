package com.merryyou.redis;

import org.junit.Test;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Created by YourName on 2015/10/26 0026.
 */
public class JsonRedisSeriazilerTest extends  BaseTest {
    @Test
    public void seriazilerTest(){
        JsonRedisSeriaziler seriaziler = new JsonRedisSeriaziler();
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set("order:" + order.getId(), seriaziler.seriazileAsString(order));
        String json = operations.get("order:" + order.getId());
        System.out.println(json);
    }
}

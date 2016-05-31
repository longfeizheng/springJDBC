package com.merryyou.redis;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Date;

/**
 * Created by YourName on 2015/10/26 0026.
 */
public class BaseTest {

    protected ApplicationContext applicationContext;
    protected StringRedisTemplate stringRedisTemplate;
    protected RedisTemplate redisTemplate;

    protected Order order;

    @Before
    public void before() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        stringRedisTemplate = applicationContext.getBean(StringRedisTemplate.class);
        redisTemplate = (RedisTemplate)applicationContext.getBean("redisTemplate");
        //stringRedisTemplate使用和redisTemplate类似


        order = new Order();
        order.setId("10000");
        order.setOrderNo("AO001");
        order.setPrice(199.6);
        order.setCreateDate(new Date());
    }
}

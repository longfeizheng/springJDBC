package com.merryyou.rabbitmq.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created on 2016/3/29 0029.
 *
 * @author zlf
 * @since 1.0
 */
public class SpringMain {
    public static void main(String[] args) throws Exception {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-rabbitmq.xml");
        //RabbitMQ模板
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
        //发送消息
        template.convertAndSend("hello world");
        Thread.sleep(1000);
        ctx.destroy();
    }
}

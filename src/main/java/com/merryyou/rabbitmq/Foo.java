package com.merryyou.rabbitmq;

/**
 * Created on 2016/3/29 0029.
 *
 * @author zlf
 * @since 1.0
 */
public class Foo {
    //具体执行业务的方法
    public void listen(String foo) {
        System.out.println("消费者： " + foo);
    }
}

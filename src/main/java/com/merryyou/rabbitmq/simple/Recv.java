package com.merryyou.rabbitmq.simple;

import com.merryyou.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 * Created on 2016/3/28 0028.
 *
 * @author zlf
 * @since 1.0
 */
public class Recv {
    private final static String QUEUE_NAME="hello";

    public static void main(String[] args) throws Exception {

        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();

        //声明队列，主要为了防止

        //创建队列消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);

        //指定消费队列
        channel.basicConsume(QUEUE_NAME,true,consumer);

        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" Received "+message+"");
        }
    }
}

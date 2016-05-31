package com.merryyou.rabbitmq.simple;

import com.merryyou.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * Created on 2016/3/28 0028.
 *
 * @author zlf
 * @since 1.0
 */
public class Send {
    //队列名称
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {

        //获得一个链接
        Connection connection = ConnectionUtil.getConnection();

        //创建一个通道
        Channel channel = connection.createChannel();

        //指定一个队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //待发送的消息
        String message = "hello world!";

        //往队列中发出一条消息

        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println(" Send "+message+" ");

        //关闭通道啊和链接
        channel.close();
        connection.close();
    }
}

package com.merryyou.rabbitmq.ps;

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
    private final static String EXCHANGE_NAME="test_exchange_fanout";

    public static void main(String[] args) throws Exception{
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        //声明转发器
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

        //消息内容
        String message = "hello world";

        channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());

        System.out.println("Send "+message);

        channel.close();
        connection.close();
    }
}

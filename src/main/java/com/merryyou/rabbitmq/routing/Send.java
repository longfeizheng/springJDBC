package com.merryyou.rabbitmq.routing;

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
    private final static String EXCHANGE_NAME ="test_exchange_direct";

    public static void main(String[] args) throws Exception{
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,"direct");

        String message ="hello world";
        channel.basicPublish(EXCHANGE_NAME,"key2",null,message.getBytes());
        System.out.println("Send "+message);

        channel.close();
        connection.close();
    }
}

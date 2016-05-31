package com.merryyou.rabbitmq.work;

import com.merryyou.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

/**
 * Created on 2016/3/28 0028.
 *
 * @author zlf
 * @since 1.0
 */
public class NewTask {
    //队列名称
    private final static String QUEUE_NAME = "workqueue";

    public static void main(String[] args) throws Exception {
        //创建链接和通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        //声明队列
        boolean durable = true;// 1、设置队列持久化
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);

        //发送10条消息，一次在消息后面附加1 - 10 个点
        for (int i = 0; i < 5; i++) {
            String dots = "";
            for (int j = 0; j <= i; j++) {
                dots += ".";
            }
            String message = "hello world" + dots + dots.length();
            channel.basicPublish("",QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
            System.out.println("Sent "+message+"");
        }
        channel.close();
        connection.close();
    }
}

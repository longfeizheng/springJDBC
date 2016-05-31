package com.merryyou.rabbitmq.work;

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
public class Work1 {
    //队列名称
    private final static String QUEUE_NAME = "workqueue";

    public static void main(String[] args) throws Exception {
        //区分不同的工作进程的输出
        int hashCode = Work1.class.hashCode();

        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        System.out.println(hashCode+"waiting for message to exit press ctrl+c");

        QueueingConsumer consumer = new QueueingConsumer(channel);

        boolean ack = false ; //打开应答机制

        //指定消费队列
        channel.basicConsume(QUEUE_NAME,ack,consumer);

        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(hashCode+"Received"+message);
            doWork(message);
            System.out.println(hashCode+"Done");
            //发送应答
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }

    private static  void doWork(String task) throws Exception{
        for(char ch : task.toCharArray()){
            if(ch =='.'){
                Thread.sleep(1000);
            }
        }
    }
}

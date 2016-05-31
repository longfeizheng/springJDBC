package com.merryyou.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created on 2016/5/1 0001.
 *
 * @author zlf
 * @since 1.0
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws Exception {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(10);
        for(int i=0 ;i<30;i++){
            blockingQueue.put(i);
            System.out.println("阻塞队列添加元素:" + i);
        }
        System.out.println("----程序结束----");
    }
}

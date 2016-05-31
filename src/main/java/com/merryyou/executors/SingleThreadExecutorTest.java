package com.merryyou.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2016/5/1 0001.
 *
 * @author zlf
 * @since 1.0
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
 * 结果依次输出，相当于顺序执行各个任务。
 */
public class SingleThreadExecutorTest {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for(int i=0 ;i<10;i++){
            final int index  = i;
            singleThreadExecutor.execute(() -> {
                try{
                    System.out.println("当前线程ID:" + Thread.currentThread().getId() + "当前线程的名字：" + Thread.currentThread().getName() + "..." + index);
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
    }
}

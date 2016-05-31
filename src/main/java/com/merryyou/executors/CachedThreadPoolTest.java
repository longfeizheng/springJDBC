package com.merryyou.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2016/5/1 0001.
 *
 * @author zlf
 * @since 1.0
 * newCachedThreadPool
 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
 */
public class CachedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(() -> System.out.println("当前线程ID:" + Thread.currentThread().getId() + "当前线程的名字：" + Thread.currentThread().getName() + "..." + index));
        }
    }
}

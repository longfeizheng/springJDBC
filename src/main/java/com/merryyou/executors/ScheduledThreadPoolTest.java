package com.merryyou.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2016/5/1 0001.
 *
 * @author zlf
 * @since 1.0
 * 创建一个定长线程池，支持定时及周期性任务执行。
 * 表示延迟3秒执行。
 * 表示延迟1秒后每3秒执行一次
 */
public class ScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
        newScheduledThreadPool.schedule((Runnable) () -> System.out.println("当前线程ID:" + Thread.currentThread().getId() + "当前线程的名字：" + Thread.currentThread().getName()+"delay 3 seconds"), 3, TimeUnit.SECONDS);
        newScheduledThreadPool.scheduleAtFixedRate((Runnable) () -> System.out.println("当前线程ID:" + Thread.currentThread().getId() + "当前线程的名字：" + Thread.currentThread().getName()+"delay 1 seconds, and excute every 3 seconds"), 1,3, TimeUnit.SECONDS);
    }
}

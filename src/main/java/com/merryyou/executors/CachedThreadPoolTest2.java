package com.merryyou.executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class CachedThreadPoolTest2 {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            final int index = i;
            singleThreadExecutor.execute(() -> {
                try {
                    while(true) {
                        System.out.println("当前线程ID:" + Thread.currentThread().getId() + "当前线程的名字：" + Thread.currentThread().getName() + "..." + index);
                        Thread.sleep(10 * 1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
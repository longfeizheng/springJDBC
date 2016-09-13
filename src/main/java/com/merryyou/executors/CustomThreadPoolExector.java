package com.merryyou.executors;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 2016/8/5 0005.
 *
 * @author zlf
 * @since 1.0
 */
public class CustomThreadPoolExector {

    private ThreadPoolExecutor pool = null;

    /**
     * 线程初始化方法
     */
    public void init(){
        pool = new ThreadPoolExecutor(
                10,
                30,
                30,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(10),
                new CustomThreadFactory(),
                new CustomRejectedExecutionHandler()
        );
    }

    public void destory(){
        if(pool!=null){
            pool.shutdownNow();
        }
    }

    public ExecutorService getCustomThreadPoolExecutor(){
        return this.pool;
    }

    private class CustomThreadFactory implements ThreadFactory{

        private AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName = CustomThreadPoolExector.class.getSimpleName()+count.addAndGet(1);
            System.out.println(threadName);
            t.setName(threadName);
            return t;
        }
    }

    private class CustomRejectedExecutionHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("error...........");
        }
    }

    public static void main(String[] args) {
        CustomThreadPoolExector exec = new CustomThreadPoolExector();
        exec.init();

        ExecutorService pool = exec.getCustomThreadPoolExecutor();
        for(int i= 1 ; i<100; i++){
            System.out.println("提交第"+i+"个任务！");
            pool.execute(() -> {
                try{
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("running....");
            });
        }

        try{
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

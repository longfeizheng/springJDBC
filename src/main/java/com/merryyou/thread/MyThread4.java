package com.merryyou.thread;

/**
 * Created on 2016/6/12 0012.
 *
 * @author zlf
 * @since 1.0
 */
public class MyThread4 extends Thread {
    private Object lock;
    public MyThread4(Object lock){
        this.lock = lock;
    }
    public void run(){
        try{
            synchronized (lock){
                System.out.println("开始     notify time="+System.currentTimeMillis());
                lock.notify();
                System.out.println("结束     notify time="+System.currentTimeMillis());
            }
        }catch (Exception e){
            e.getMessage();
        }
    }
}

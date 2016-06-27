package com.merryyou.thread;

/**
 * Created on 2016/6/12 0012.
 *
 * @author zlf
 * @since 1.0
 */
public class MyThread3 extends Thread {
    private Object lock;
    public MyThread3(Object lock){
        this.lock = lock;
    }
    public void run(){
        try{
            synchronized (lock){
                System.out.println("开始     wait time="+System.currentTimeMillis());
                lock.wait();
                System.out.println("结束     wait time="+System.currentTimeMillis());
            }
        }catch (Exception e){
            e.getMessage();
        }
    }
}

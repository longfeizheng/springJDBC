package com.merryyou.reentrantLock;

/**
 * Created on 2016/6/12 0012.
 *
 * @author zlf
 * @since 1.0
 */
public class MyThread1 extends Thread {
    private MyService1 service;
    public MyThread1(MyService1 service){
        this.service=service;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            service.set();
        }
    }
}

package com.merryyou.reentrantLock;

/**
 * Created on 2016/6/12 0012.
 *
 * @author zlf
 * @since 1.0
 */
public class ThreadA extends Thread {
    private Service3 service;

    public ThreadA(Service3 service){
        this.service=service;
    }

    @Override
    public void run() {
        service.read();
    }
}

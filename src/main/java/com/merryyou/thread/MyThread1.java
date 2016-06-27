package com.merryyou.thread;

/**
 * Created on 2016/6/7 0007.
 *
 * @author zlf
 * @since 1.0
 */
public class MyThread1 extends Thread {
    private int count = 5;

    @Override
    public void run() {
        super.run();
            count -- ;
            System.out.println("由"+currentThread().getName()+"计算 count "+count);
    }
}

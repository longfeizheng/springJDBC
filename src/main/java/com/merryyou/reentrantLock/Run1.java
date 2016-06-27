package com.merryyou.reentrantLock;

/**
 * Created on 2016/6/12 0012.
 *
 * @author zlf
 * @since 1.0
 */
public class Run1 {
    public static void main(String[] args) {
        MyService1 service = new MyService1();
        MyThread1 a = new MyThread1(service);
        a.start();
        MyThread2 b = new MyThread2(service);
        b.start();
    }
}

package com.merryyou.thread;

/**
 * Created on 2016/6/7 0007.
 *
 * @author zlf
 * @since 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyThread1 myThread = new MyThread1();
            Thread a = new Thread(myThread,"A"+i);
            Thread b = new Thread(myThread,"B"+i);
            Thread c = new Thread(myThread,"C"+i);
            Thread d = new Thread(myThread,"D"+i);
            Thread e = new Thread(myThread,"E"+i);
            a.start();
            b.start();
            c.start();
            d.start();
            e.start();
        }

    }
}

package com.merryyou.thread;

/**
 * Created on 2016/6/12 0012.
 *
 * @author zlf
 * @since 1.0
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.start();
        for (int i = 0; i < 60; i++) {
            System.out.println("Hello world   run ----" + i);
        }
    }
}

class Demo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 60; i++) {
            System.out.println("demo run ----" + i);
        }
    }
}

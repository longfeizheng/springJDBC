package com.merryyou.thread;

/**
 * Created on 2016/6/7 0007.
 *
 * @author zlf
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread().getName());

        MyThread thread = new MyThread();
        thread.setName("myThread");
        thread.start();
        for (int i = 0; i < 10; i++) {
            int time = (int) (Math.random() * 1000);
            Thread.sleep(time);
            System.out.println("main=" + Thread.currentThread().getName());
        }
    }
}

package com.merryyou.thread;

/**
 * Created on 2016/6/12 0012.
 *
 * @author zlf
 * @since 1.0
 */
public class Test5 {
    public static void main(String[] args) {
        try{
            Object lock = new Object();
            MyThread3 t1 = new MyThread3(lock);
            t1.start();
            Thread.sleep(3000);
            MyThread4 t2 = new MyThread4(lock);
            t2.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

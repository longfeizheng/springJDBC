package com.merryyou.thread;

/**
 * Created on 2016/6/12 0012.
 *
 * @author zlf
 * @since 1.0
 */
public class ThreadJoinTest {
    public static void main(String[] args) {
        ThreadJoin threadJoin = new ThreadJoin();
        threadJoin.start();
        try {
            threadJoin.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
    }
}

package com.merryyou.reentrantLock;

/**
 * Created on 2016/6/13 0013.
 *
 * @author zlf
 * @since 1.0
 */
public class LockTest {
    public static void main(String[] args) {
        final Outputter1 output = new Outputter1();

        new Thread(){
            @Override
            public void run() {
                output.output("zhangsan");
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                output.output("lisi");
            }
        }.start();
    }
}

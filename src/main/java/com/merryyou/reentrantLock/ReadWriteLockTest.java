package com.merryyou.reentrantLock;

import java.util.Random;

/**
 * Created on 2016/6/13 0013.
 *
 * @author zlf
 * @since 1.0
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        final Data data = new Data();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    data.set(new Random().nextInt());
                }
            }).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(() ->{
                for (int j = 0; j < 5; j++) {
                    data.get();
                }
            }).start();
        }
    }
}

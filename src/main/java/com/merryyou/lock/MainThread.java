package com.merryyou.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2016/5/1 0001.
 *
 * @author zlf
 * @since 1.0
 */
public class MainThread {
    public static void main(String[] args) {
        BankCard bc = new BankCard();
        Lock lock = new ReentrantLock();
        ExecutorService pool = Executors.newCachedThreadPool();
        Consumer cm1 = new Consumer(bc, lock);
        Consumer2 cm2 = new Consumer2(bc, lock);
        pool.execute(cm1);
        pool.execute(cm2);
    }
}

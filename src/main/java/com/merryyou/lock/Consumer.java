package com.merryyou.lock;

import java.util.concurrent.locks.Lock;

/**
 * Created on 2016/5/1 0001.
 *
 * @author zlf
 * @since 1.0
 */
public class Consumer implements Runnable {
    BankCard bc = null;
    Lock lock = null;

    Consumer(BankCard bc, Lock lock) {
        this.bc = bc;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            while (true) {
                lock.lock();
                System.out.print("儿子要消费，现在余额：" + bc.getBalance() + "\t");
                bc.setBalance(bc.getBalance() - 2000);
                System.out.println("儿子消费2000元，现在余额：" + bc.getBalance());
                Thread.sleep(1 * 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

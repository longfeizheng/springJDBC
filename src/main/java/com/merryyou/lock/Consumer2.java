package com.merryyou.lock;

import java.util.concurrent.locks.Lock;

/**
 * Created on 2016/5/1 0001.
 *
 * @author zlf
 * @since 1.0
 */
public class Consumer2 implements Runnable {
    BankCard bc = null;
    Lock lock = null;

    Consumer2(BankCard bc, Lock lock) {
        this.bc = bc;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            while (true) {
                lock.lock();
                System.out.print("父亲要存钱，现在余额：" + bc.getBalance() + "\t");
                bc.setBalance(bc.getBalance() + 500);
                System.out.println("父亲存入500元，现在余额：" + bc.getBalance());
                Thread.sleep(3 * 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

package com.merryyou.reentrantLock;

/**
 * Created on 2016/6/14 0014.
 *
 * @author zlf
 * @since 1.0
 */
public class LockDemo {
    public static void main(String[] args) {
//        Lock  lock = new ReentrantLock();
        while (true){
            System.out.println("锁前输出。。。。");
//            lock.lock();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("锁后输出。。。");
        }
    }
}

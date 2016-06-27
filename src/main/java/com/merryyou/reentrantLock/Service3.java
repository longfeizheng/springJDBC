package com.merryyou.reentrantLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created on 2016/6/12 0012.
 *
 * @author zlf
 * @since 1.0
 */
public class Service3 {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void read(){
        try{
            lock.readLock().lock();
            System.out.println("获得读锁 "+Thread.currentThread().getName()+".."+System.currentTimeMillis());
            Thread.sleep(10000);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }
}

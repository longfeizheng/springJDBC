package com.merryyou.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2016/6/13 0013.
 *
 * @author zlf
 * @since 1.0
 */
public class Outputter1 {
    private Lock lock = new ReentrantLock();

    public void output(String name){
        lock.lock();
        try{
            for (int i = 0; i < name.length(); i++) {
                System.out.println(name.charAt(i));
            }
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}

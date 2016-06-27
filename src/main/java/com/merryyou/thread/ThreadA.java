package com.merryyou.thread;

/**
 * Created on 2016/6/12 0012.
 *
 * @author zlf
 * @since 1.0
 */
public class ThreadA extends Thread {
    private Object lock;
    public ThreadA (Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
           synchronized (lock){
               if(MyList.size() != 5){
                   System.out.println("wait begin " + System.currentTimeMillis());
                   lock.wait();
                   System.out.println("wait end" + System.currentTimeMillis());
               }
           }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

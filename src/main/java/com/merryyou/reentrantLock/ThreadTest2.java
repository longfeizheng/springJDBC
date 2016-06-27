package com.merryyou.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2016/6/13 0013.
 *
 * @author zlf
 * @since 1.0
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(() -> {
            threadExecute(business,"sub");
        }).start();
        threadExecute(business,"main");
//        final BusinessLock business = new BusinessLock();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                threadExecute2(business,"sub");
//            }
//        }).start();
//        threadExecute2(business,"main");
    }

    public static void threadExecute(Business business , String threadType){
        for (int i = 0; i < 100; i++) {
            try{
                if("main".equals(threadType)){
                    business.main(i);
                }else{
                    business.sub(i);
                }
            }catch (Exception e){

            }
        }
    }
    public static void threadExecute2(BusinessLock businessLock , String threadType){
        for (int i = 0; i < 100; i++) {
            try{
                if("main".equals(threadType)){
                    businessLock.main(i);
                }else{
                    businessLock.sub(i);
                }
            }catch (Exception e){

            }
        }
    }

}
class Business{
    private boolean bool = true;

    public synchronized  void main(int loop) throws Exception{
        while (bool){
            wait();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("main thread seq of "+i+", loop of" + loop);
        }
        bool = true;
    }

    public synchronized  void sub (int loop) throws  Exception{
        while (!bool){
            this.wait();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("sub thread seq of "+i+", loop of" + loop);
        }
        bool = false;
        this.notify();
    }

}
class BusinessLock{
    private boolean bool = true;
    private ReentrantLock lock = new ReentrantLock();

    public  void main(int loop) throws Exception{
        try{
            while (bool){
                lock.lock();
            }
            for (int i = 0; i < 100; i++) {
                System.out.println("main thread seq of "+i+", loop of" + loop);
            }
            bool = true;
        }finally {
            lock.unlock();
        }
    }
    public   void sub (int loop) throws  Exception{
        try{
            while (!bool){
                lock.lock();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("sub thread seq of "+i+", loop of" + loop);
            }
            bool = false;
        }finally {
            lock.unlock();
        }

    }
}

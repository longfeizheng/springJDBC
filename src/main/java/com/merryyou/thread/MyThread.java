package com.merryyou.thread;

/**
 * Created on 2016/6/7 0007.
 *
 * @author zlf
 * @since 1.0
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        try{
            for(int i=0;i<10;i++){
                int time = (int)(Math.random()*1000);
                Thread.sleep(time);
                System.out.println("run="+Thread.currentThread().getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

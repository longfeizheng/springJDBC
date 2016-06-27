package com.merryyou.concurrent;

/**
 * Created on 2016/6/7 0007.
 *
 * @author zlf
 * @since 1.0
 */
public class MyRun {
    public static void main(String[] args) throws Exception{
        RunThread thread = new RunThread();
        thread.start();
        Thread.sleep(100);
        thread.setRunning(false);
        System.out.println("flag is reseted:"+thread.isRunning());
    }
}

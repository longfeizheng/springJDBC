package com.merryyou.concurrent;

/**
 * Created on 2016/6/7 0007.
 *
 * @author zlf
 * @since 1.0
 */
public class RunThread extends Thread {

    private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("i'am come in ...");
        boolean first = true;
        while(isRunning){
            if(first){
                System.out.println("i'am in while ...");
                first = false;
            }
        }

        System.out.println("i'am go out..");
    }
}

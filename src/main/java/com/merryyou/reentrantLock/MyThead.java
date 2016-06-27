package com.merryyou.reentrantLock;

/**
 * Created on 2016/6/12 0012.
 *
 * @author zlf
 * @since 1.0
 */
public class MyThead extends Thread {
    private MyService myService;
    public MyThead(MyService myService){
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}

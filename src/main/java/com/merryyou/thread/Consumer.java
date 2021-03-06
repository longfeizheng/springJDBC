package com.merryyou.thread;

/**
 * Created on 2016/6/13 0013.
 *
 * @author zlf
 * @since 1.0
 */
public class Consumer implements Runnable {

    private Resource res;

    Consumer(Resource res)
    {
        this.res = res;
    }

    @Override
    public void run() {
        while(true)
        {
            res.out();
        }
    }
}

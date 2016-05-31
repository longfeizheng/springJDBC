package com.merryyou.test.callBack;

/**
 * Created on 2016/2/29 0029.
 *
 * @author zlf
 * @since 1.0
 */
public class Caller {
    private MyCallback myCallback;

    public void doCall(){
         myCallback.func();
    }

    public void setMyCallback(MyCallback myCallback) {
        this.myCallback = myCallback;
    }
}

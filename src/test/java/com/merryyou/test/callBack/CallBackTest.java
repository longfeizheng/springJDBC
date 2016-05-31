package com.merryyou.test.callBack;

/**
 * Created on 2016/2/29 0029.
 *
 * @author zlf
 * @since 1.0
 */
public class CallBackTest {
    public static void main(String[] args) {
        Caller caller = new Caller();
        caller.setMyCallback(new MyCallback() {
            @Override
            public void func() {
                System.out.println("Hello world");
            }
        });
        caller.doCall();
    }
}

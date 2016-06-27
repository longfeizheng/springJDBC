package com.merryyou.thread;

/**
 * Created on 2016/6/8 0008.
 *
 * @author zlf
 * @since 1.0
 */
public class LoginServletTest {
    public static void main(String[] args) {
        ALogin a = new ALogin();
        a.start();
        BLogin b = new BLogin();
        b.start();
    }
}

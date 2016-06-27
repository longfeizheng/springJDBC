package com.merryyou.thread;

/**
 * Created on 2016/6/8 0008.
 *
 * @author zlf
 * @since 1.0
 */
public class ALogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("a","aa");
    }
}

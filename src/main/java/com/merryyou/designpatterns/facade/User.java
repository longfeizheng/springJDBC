package com.merryyou.designpatterns.facade;

/**
 * Created on 2016/5/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class User {
    public static void main(String[] args) {
        Computer computer  = new Computer();
        computer.startup();
        computer.shutdown();
    }
}

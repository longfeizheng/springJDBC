package com.merryyou.designpatterns.facade;

/**
 * Created on 2016/5/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class CPU {
    public void startup(){
        System.out.println("cpu startup!");
    }
    public void shutdown(){
        System.out.println("cpu shutdown!");
    }
}

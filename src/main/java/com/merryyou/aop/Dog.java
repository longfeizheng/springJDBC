package com.merryyou.aop;

/**
 * Created on 2016/3/22 0022.
 *
 * @author zlf
 * @since 1.0
 */
public class Dog implements Animal {
    @Override
    public void run() {
        System.out.println("小狗开始跑！");
    }

    @Override
    public void jump() {
        System.out.println("小狗开始跳！");
    }
}

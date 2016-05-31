package com.merryyou.test.singleton;

/**
 * Created on 2016/2/14 0014.
 * 饿汉式：new之后，便创建对象。
 * 此种方式不用考虑线程是否安全。
 *
 * @author zlf
 * @since 1.0
 */
public class SingletonHunger {
    private SingletonHunger() {
    }

    ; //私有化构造方法
    private static SingletonHunger s = new SingletonHunger(); //创建SingletonHunger对象  必须静态

    private static SingletonHunger getInstance() {
        return s;
    }

}

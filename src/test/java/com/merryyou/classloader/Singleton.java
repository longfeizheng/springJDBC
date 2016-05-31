package com.merryyou.classloader;

/**
 * Created on 2016/2/2 0002.
 *
 * @author zlf
 * @since 1.0
 */
public class Singleton {


    public static int counter1;
    public static int counter2=0;

    private static Singleton singleton = new Singleton();

    private Singleton(){
        counter1++;
        counter2++;
    }

    public static Singleton getInstance(){
        return singleton;
    }
}

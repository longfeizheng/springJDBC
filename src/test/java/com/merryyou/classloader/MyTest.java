package com.merryyou.classloader;

/**
 * Created on 2016/1/22 0022.
 *
 * @author zlf
 * @since 1.0
 */
public class MyTest{

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1 = "+ singleton.counter1);
        System.out.println("counter2 = "+ singleton.counter2);
    }
}



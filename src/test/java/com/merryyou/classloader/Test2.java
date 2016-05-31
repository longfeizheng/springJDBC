package com.merryyou.classloader;

/**
 * Created on 2016/2/2 0002.
 *
 * @author zlf
 * @since 1.0
 */
class FinalTest1 {
    public static final int x = 6 / 3;

    static {
        System.out.printf("FinalTest1 static block");
    }
}

public class Test2 {
    public static void main(String[] args) {
        System.out.println(FinalTest1.x);
    }
}

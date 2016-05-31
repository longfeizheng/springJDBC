package com.merryyou.classloader;

import java.util.Random;

/**
 * Created on 2016/2/2 0002.
 *
 * @author zlf
 * @since 1.0
 */
class FinalTest2{
    static {
        System.out.println("FinalTest2 static block ");
    }
    public static final int x = new Random().nextInt(100);

}
public class Test1 {
    public static void main(String[] args) {
        System.out.println(FinalTest2.x);
    }
}

package com.merryyou.test.litter;

/**
 * Created on 2016/4/25 0025.
 *
 * @author zlf
 * @since 1.0
 */
public class Persion {
    public static String name = "Jack";

    public static void changeName(Persion p){
        p.name ="Rose";
    }

    public static void main(String[] args) {
        Persion p = new Persion();
        System.out.println(p.name);
        changeName(p);
        System.out.println(p.name);
    }
}

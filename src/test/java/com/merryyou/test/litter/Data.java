package com.merryyou.test.litter;

/**
 * Created on 2016/4/25 0025.
 *
 * @author zlf
 * @since 1.0
 */
public class Data {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(num);
        changeValre(num);
        System.out.println(num);
    }

    public static void changeValre(int x){
        x = x * 2;
    }
}

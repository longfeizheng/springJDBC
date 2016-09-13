package com.merryyou.test;

/**
 * Created on 2016/7/22 0022.
 *
 * @author zlf
 * @since 1.0
 */
public class StringTest {
    public static void main(String[] args) {
        String s = "1"+"2";
        String s1 = "12";
        String s3 = "1";
        String s4 ="2";
        System.out.println(s==s1);
        System.out.println(s1 == (s3+s4));
    }
}

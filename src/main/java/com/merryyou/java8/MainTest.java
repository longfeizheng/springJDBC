package com.merryyou.java8;

import java.util.Arrays;

/**
 * Created on 2016/5/28 0028.
 *
 * @author zlf
 * @since 1.0
 */
public class MainTest {
    public static void main(String[] args) {
        Arrays.asList("a","b","c").forEach(e -> System.out.print(e));
        System.out.println("-------------------------------------------");
        Arrays.asList("a","b","c").forEach((String e) -> System.out.print(e));
        System.out.println("-------------------------------------------");
        Arrays.asList("a","b","c").forEach(e -> {
            System.out.print(e);
            System.out.print(e);
        });
        System.out.println("-------------------------------------------");
        Arrays.asList("a","b","c").sort((e1 ,e2 ) -> e1.compareTo(e2));
    }
}

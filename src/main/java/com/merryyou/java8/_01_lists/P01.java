package com.merryyou.java8._01_lists;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created on 2016/9/6 0006.
 *
 * @author zlf
 * @since 1.0
 */
public class P01 {
    public static void main(String[] args) {
        List<String> stringList = asList("a", "b", "c", "d");
        List<String> newList = stringList.subList(1,stringList.size());
        System.out.println(newList.toString());
    }
}

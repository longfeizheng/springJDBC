package com.merryyou.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created on 2016/5/29 0029.
 *
 * @author zlf
 * @since 1.0
 */
public class StreamTest {
    public static void main(String[] args) {
        //构造流的几种常见方法
        //1.字符串
        Stream stream = Stream.of("a","b","c");
        //2.数组
        String[] strArray = new String[]{"a","b","c"};
        stream = Stream.of(strArray);
        //3.集合
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();

        //数值流的构造
        IntStream.of(new int[]{1,2,3})
                .forEach(System.out::print);
        IntStream.range(1,3)
                .forEach(System.out::print);
        IntStream.rangeClosed(1,3)
                .forEach(System.out::print);

        //流转换成其它数据结构
//        String[] strArray1 = (String[]) stream.toArray(String[]::new);
//        List<String> list1 = (List<String>) stream.collect(Collectors.toList());
//        List<String> list2 = (List<String>) stream.collect(Collectors.toCollection(ArrayList::new));

        //流的操作
        List<Integer> nums = Arrays.asList(1,2,3,4);
        //map 生成的是个 1:1 映射，每个输入元素，都按照规则转换成为另外一个元素。
        List<Integer> squareNums = nums
                .stream()
                .map(n -> n*n)
                .collect(Collectors.toList());
        nums.forEach(System.out::println);
        squareNums.forEach(System.out::println);

        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2,3),
                Arrays.asList(4,5,6)
        );
        //一对多映射关系的，这时需要 flatMap。
        List<Integer> outputStream = inputStream
                .flatMap((childList) -> childList.stream())
                .collect(Collectors.toList());
        outputStream.forEach(System.out::println);

        //filter 过滤
        Integer[] sixNums = {1,2,3,4,5,6};
        Integer[] evens = Stream.of(sixNums)
                .filter( n -> n%2==0)
                .toArray(Integer[]::new);
    }
}

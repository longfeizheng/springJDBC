package com.merryyou.annotation;

import java.lang.reflect.Field;

/**
 * Created on 2016/9/9 0009.
 *
 * @author zlf
 * @since 1.0
 */
public class AppleTest {
    public static void main(String[] args) {
        Class<Apple> testClass = Apple.class;
        Field[] fields = testClass.getDeclaredFields();
        for(Field fd :fields){
            if(fd.isAnnotationPresent(FruitName.class)){
                FruitName f = fd.getAnnotation(FruitName.class);
                System.out.println(f.value());
            }
        }
    }
}

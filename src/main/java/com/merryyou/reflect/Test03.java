package com.merryyou.reflect;

/**
 * Created on 2016/10/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class Test03 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.merryyou.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person per = null;
        try {
            per = (Person) demo.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        per.setName("Tom");
        per.setAge(20);
        System.out.println(per);
    }
}

package com.merryyou.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created on 2016/10/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class Test04 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.merryyou.reflect.Person01");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person01 per1 = null;

        Constructor<?>[] cons = demo.getConstructors();//获得全部的构造函数

        try {
            per1 = (Person01)cons[0].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(per1);
    }
}

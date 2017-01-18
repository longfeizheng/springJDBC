package com.merryyou.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created on 2016/10/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class Test09 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.merryyou.reflect.Person01");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Method method = demo.getMethod("sayChina");
            method.invoke(demo.newInstance());//对带有指定参数的指定对象调用由此 Method 对象表示的底层方法。
            //调用Person的sayHello方法
            method=demo.getMethod("sayHello", String.class,int.class);//返回一个 Method 对象，它反映此 Class 对象所表示的类或接口的指定公共成员方法。
            method.invoke(demo.newInstance(),"Tom",20);//对带有指定参数的指定对象调用由此 Method 对象表示的底层方法。
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

package com.merryyou.reflect;

import java.lang.reflect.Constructor;

/**
 * Created on 2016/10/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class Test05 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.merryyou.reflect.Person01");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<?>[] cons = demo.getConstructors();//返回一个包含某些 Constructor 对象的数组，这些对象反映此 Class 对象所表示的类的所有公共构造方法。
        for(Constructor c: cons){
            c.setAccessible(true);
            System.out.println("构造方法:"+c);
        }
    }
}

package com.merryyou.reflect;

/**
 * 添加一句：所有类的对象其实都是Class的实例。
 * Created on 2016/10/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class Test02 {
    public static void main(String[] args) {
        Class<?> demo1 = null;
        Class<?> demo2 = null;
        Class<?> demo3 = null;
        try {
            demo1 = Class.forName("com.merryyou.reflect.Demo");//一般采用这种形式
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        demo2 = new Demo().getClass();
        demo3 = Demo.class;

        System.out.println("类名称："+demo1.getName());
        System.out.println("类名称："+demo2.getName());
        System.out.println("类名称："+demo3.getName());
    }
}

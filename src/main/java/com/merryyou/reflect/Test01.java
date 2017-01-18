package com.merryyou.reflect;

/**
 * 通过一个对象获得完整的包名和类名
 * Created on 2016/10/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        Demo  demo = new Demo();
        System.out.println(demo.getClass().getName());
    }
}

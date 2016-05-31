package com.merryyou.classloader;

/**
 * Created on 2016/2/2 0002.
 *
 * @author zlf
 * @since 1.0
 */
class Parent{
    static int a =3;
    static {
        System.out.println("parent static block");
    }
}
class Child extends Parent{
    static int a =4;
    static {
        System.out.println("Child static block");
    }
}
public class Test3 {
    static {
        System.out.println("Test3 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child.a);
    }
}

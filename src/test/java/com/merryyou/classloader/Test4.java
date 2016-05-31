package com.merryyou.classloader;

/**
 * Created on 2016/2/2 0002.
 *
 * @author zlf
 * @since 1.0
 */
class Parent2{
    static int a =3;
    static {
        System.out.println("pareng2 static block");
    }
}
class Chiled2 extends Parent2{
    static int a =4;
    static {
        System.out.println("Chiled2 static block");
    }
}
public class Test4 {
    static {
        System.out.println("Test4 static block");
    }

    public static void main(String[] args) {
        Parent2 parent;

        System.out.println("_------------------");
        parent = new Parent2();
        System.out.println(Parent2.a);
        System.out.println(Chiled2.a );
    }
}

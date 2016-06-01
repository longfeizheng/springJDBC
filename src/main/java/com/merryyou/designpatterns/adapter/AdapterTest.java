package com.merryyou.designpatterns.adapter;

/**
 * Created on 2016/5/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class AdapterTest {
    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method1();
        target.method2();

        Source source = new Source();
        Targetable targetable = new Warpper(source);
        targetable.method1();
        target.method2();
    }
}

package com.merryyou.designpatterns.adapter;

/**
 * Created on 2016/5/31 0031.
 *
 * @author zlf
 * @since 1.0
 * 类的适配
 */
public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}

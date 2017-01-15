package com.merryyou.designpatterns.proxy;

/**
 * Created on 2016/5/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class SourceableImpl implements Sourceable {
    @Override
    public void method() {
        System.out.println("this original method");
    }
}

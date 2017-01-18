package com.merryyou.designpatterns.proxy;

/**
 * Created on 2016/11/16 0016.
 *
 * @author zlf
 * @since 1.0
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        DynamicProxy proxy = new DynamicProxy();
        Sourceable sourceable = (Sourceable) proxy.bind(new SourceableImpl());
        sourceable.method();
    }
}

package com.merryyou.designpatterns.proxy;

/**
 * Created on 2016/11/16 0016.
 *
 * @author zlf
 * @since 1.0
 */
public class DynamicCglibProxyTest {
    public static void main(String[] args) {
        DynamicCglibProxy cglib=new DynamicCglibProxy();
        SourceableImpl cglibInstance=(SourceableImpl)cglib.getInstance(new SourceableImpl());
        cglibInstance.method();
    }
}

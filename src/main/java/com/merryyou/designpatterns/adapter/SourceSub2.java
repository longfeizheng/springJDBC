package com.merryyou.designpatterns.adapter;

/**
 * Created on 2016/5/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class SourceSub2 extends Wrapper2 {
    @Override
    public void method2(){
        System.out.println("this sourceable interface second sub1");
    }
}

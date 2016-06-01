package com.merryyou.designpatterns.bridge;

/**
 * Created on 2016/5/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public abstract class Bridge {
    private Sourceable source;

    public void method(){
        source.method();
    }

    public Sourceable getSource(){
        return source;
    }
    public void setSource(Sourceable source){
        this.source = source;
    }
}

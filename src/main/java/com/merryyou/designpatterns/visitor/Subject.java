package com.merryyou.designpatterns.visitor;

/**
 * Created on 2016/6/1 0001.
 *
 * @author zlf
 * @since 1.0
 */
public interface Subject {
    public void accept(Visitor visitor);
    public String getSubject();
}

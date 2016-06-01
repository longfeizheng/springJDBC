package com.merryyou.designpatterns.observer;

/**
 * Created on 2016/5/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public interface Subject {
    //增加观察者
    public void add(Obserer obserer);

    //删除观察者
    public void del(Obserer obserer);

    //通知所有观察者
    public void notifyObservers();

    //自身的操作
    public void operation();
}

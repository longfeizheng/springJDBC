package com.merryyou.designpatterns.observer;

/**
 * Created on 2016/5/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class Observer1 implements Obserer {
    @Override
    public void update() {
        System.out.println("observer1 has received!");
    }
}

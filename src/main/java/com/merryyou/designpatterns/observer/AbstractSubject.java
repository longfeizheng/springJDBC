package com.merryyou.designpatterns.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created on 2016/5/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public abstract class AbstractSubject implements Subject {
    private Vector<Obserer> vector = new Vector<>();

    @Override
    public void add(Obserer obserer) {
        vector.add(obserer);
    }

    @Override
    public void del(Obserer obserer) {
        vector.remove(obserer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Obserer> elements = vector.elements();
        while (elements.hasMoreElements()){
            elements.nextElement().update();
        }
    }
}

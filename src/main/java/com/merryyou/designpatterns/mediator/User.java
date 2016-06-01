package com.merryyou.designpatterns.mediator;

/**
 * Created on 2016/6/1 0001.
 *
 * @author zlf
 * @since 1.0
 */
public abstract class User {
    private Mediator mediator;

    public abstract void work();

    public Mediator getMediator() {
        return mediator;
    }

    public User(Mediator mediator) {
        this.mediator = mediator;
    }
}

package com.merryyou.designpatterns.mediator;

/**
 * Created on 2016/6/1 0001.
 *
 * @author zlf
 * @since 1.0
 */
public class User2 extends User {

    public User2(Mediator mediator){
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user2 exe!");
    }
}

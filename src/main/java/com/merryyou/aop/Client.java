package com.merryyou.aop;

/**
 * Created on 2016/3/22 0022.
 *
 * @author zlf
 * @since 1.0
 */
public class Client {
    public static void main(String[] args) {
        MyProxy hander = new MyProxy();
        Animal dog = (Animal) hander.createProxyInstance(new Dog());
        dog.run();
        dog.jump();
    }
}

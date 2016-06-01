package com.merryyou.designpatterns.memento;

/**
 * Created on 2016/6/1 0001.
 *
 * @author zlf
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) {

        //创建原始类
        Original origi = new Original("egg");

        //创建备忘录
        Storage storage = new Storage(origi.createMemento());

        //修改原始类状态
        System.out.println("初始化状态为 ："+origi.getValue());
        origi.setValue("niu");
        System.out.println("修改后的状态为："+origi.getValue());

        //回复原始的状态
        origi.restoreMemento(storage.getMemento());
        System.out.println("恢复后的状态为："+origi.getValue());

    }
}

package com.merryyou.thread;

/**
 * Created on 2016/6/12 0012.
 *
 * @author zlf
 * @since 1.0
 */
public class ThreadTest {
    public static void main(String[] args) {
        Test2 t1 = new Test2("one --");
        Test2 t2 = new Test2("two +++");
        t1.start();
        t2.start();
        for (int i = 0; i < 60; i++) {
            System.out.println("main ..." + i);
        }
    }
}
class Test2 extends Thread{
    Test2(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 60; i++) {
            System.out.println((Thread.currentThread()==this)+"..."+this.getName()+"run ..." + i);
        }
    }
}

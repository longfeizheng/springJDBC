package com.merryyou.reentrantLock;


/**
 * Created on 2016/6/12 0012.
 *
 * @author zlf
 * @since 1.0
 */
public class Run {
    public static void main(String[] args) {
        MyService service= new MyService();
        MyThead a1 = new MyThead(service);
        MyThead a2 = new MyThead(service);
        MyThead a3 = new MyThead(service);
        MyThead a4 = new MyThead(service);
        MyThead a5 = new MyThead(service);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
    }
}

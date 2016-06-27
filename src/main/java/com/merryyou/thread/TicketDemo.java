package com.merryyou.thread;

/**
 * Created on 2016/6/12 0012.
 *
 * @author zlf
 * @since 1.0
 */
public class TicketDemo {
    public static void main(String[] args) {
        Ticket t = new Ticket();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }


}
class Ticket implements Runnable{

    private int tick = 100;

    @Override
    public void run() {
        while (true){
            if(tick>0){
                System.out.println(Thread.currentThread().getName()+"...sale..."+tick--);
            }
        }
    }
}

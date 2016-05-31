package com.merryyou.threadlocal;

/**
 * Created on 2016/5/1 0001.
 *
 * @author zlf
 * @since 1.0
 * 每个线程执行时将会把局部变量放在各自栈帧的工作内存中，线程间不共享，所以没有安全问题。
 * synchronized是利用锁的机制，使变量或代码块在某一时该只能被一个线程访问。而ThreadLocal为每一个线程都提供了变量的副本，使得每个线程在某一时间访问到的并不是同一个对象，这样就隔离了多个线程对数据的数据共享。而Synchronized却正好相反，它用于在多个线程间通信时能够获得数据共享。Synchronized用于线程间的数据共享，而ThreadLocal则用于线程间的数据隔离。当然ThreadLocal并不能替代synchronized,它们处理不同的问题域。synchronized是用来处理多线程环境下的数据同步,而ThreadLocal只是为了保存当前线程私有的某种状态
 */
public class ThreadLocalTest3 {
    public static void main(String[] args) {
        Runnable accumelatora = new Accumulatort3();
        Thread threada = new Thread(accumelatora, "ThreadA");
        Thread threadb = new Thread(accumelatora, "ThreadB");
        threada.start();
        threadb.start();
    }
}

class Accumulatort3 implements Runnable {
    @SuppressWarnings("unchecked")
    public void run() {
        // 局部变量
        int locals = 0;
        for (int i = 0; i <= 5; i++) {
            locals += 1;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println(Thread.currentThread().getName() + "-->"
                    + locals);
        }
    }
}

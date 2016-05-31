package com.merryyou.threadlocal;

/**
 * Created on 2016/5/1 0001.
 *
 * @author zlf
 * @since 1.0
 * 实例变量为对象实例私有，在java虚拟机的堆中分配，如果在系统中只存在一个此对象的实例，在多线程环境下，就像静态变量那样，被某个线程修改后，其他线程对修改均可见，故线程非安全；如果每个线程执行都是在不同的对象中，那对象与对象之间的实例变量的修改将互不影响，所以线程安全
 */
public class ThreadLocalTest2 {
    public static void main(String[] args) {
        Runnable accumelatora = new Accumulatort2();
//        Runnable accumelator1 = new Accumulatort2();
        Thread threada = new Thread(accumelatora, "ThreadA");
        Thread threadb = new Thread(accumelatora, "ThreadB");
        threada.start();
        threadb.start();
    }
}

class Accumulatort2 implements Runnable {
    // 实例变量
    int locals = 0;

    @SuppressWarnings("unchecked")
    public void run() {
        for (int i = 0; i <= 10; i++) {
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

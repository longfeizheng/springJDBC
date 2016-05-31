package com.merryyou.threadlocal;

/**
 * Created on 2016/5/1 0001.
 *
 * @author zlf
 * @since 1.0
 * 运行后看控制台输出，很容就发现有时候某线程使用变量时已经被另一个线程修改了。
 * 因为静态变量是 静态存储方式，所谓静态存储方式是指在程序运行期间分配固定的存储空间的方式。也就是说不管多少线程，访问都是一个变量，安全问题显而易见。
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        Runnable accumelatora = new Accumulatort();
        Thread threada = new Thread(accumelatora, "ThreadA");
        Thread threadb = new Thread(accumelatora, "ThreadB");
        threada.start();
        threadb.start();
    }
}

class Accumulatort implements Runnable {
    // 静态变量
    private static int local = 0;

    @SuppressWarnings("unchecked")
    public void run() {
        // 静态变量
        for (int i = 0; i <= 10; i++) {
            local += 1;
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
            System.out.println(Thread.currentThread().getName() + "-->"
                    + local);
        }
    }
}
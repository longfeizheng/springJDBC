package com.merryyou.thread;

/**
 * Created on 2016/6/12 0012.
 *
 * @author zlf
 * @since 1.0
 */
public class Test4 {
    public static void main(String[] args) {
        try {
            String lock = new String();
            System.out.println("syn 上面");
            synchronized (lock){
                System.out.println("syn第一行");
                lock.wait();
                System.out.println("wait下的代码");
            }
            System.out.println("syn下面的代码");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

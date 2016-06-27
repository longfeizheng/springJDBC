package com.merryyou.thread;

/**
 * Created on 2016/6/13 0013.
 *
 * @author zlf
 * @since 1.0
 */
public class Resource {
    private String name;
    private int count = 1;
    private boolean flag = false;

    public synchronized void set(String name){
        while (flag){
            try{this.wait();}catch(Exception e){}//t1(放弃资格)  t2(获取资格)
        }
        this.name = name +"..."+count++;

        System.out.println(Thread.currentThread().getName()+"....生产者。。。"+this.name);
        flag = true;
        this.notifyAll();
    }

    public synchronized void out(){
        while (!flag){
            try{wait();}catch(Exception e){}//t3(放弃资格) t4(放弃资格)
        }

        System.out.println(Thread.currentThread().getName()+"...消费者..."+this.name);
        flag = false;
        this.notifyAll();
    }

}

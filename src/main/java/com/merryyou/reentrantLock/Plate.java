package com.merryyou.reentrantLock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2016/6/13 0013.
 *
 * 定义一个盘子类，可以放鸡蛋和取鸡蛋
 * @author zlf
 * @since 1.0
 */
public class Plate {
    //装鸡蛋的盘子
    List<Object> eggs = new ArrayList<Object>();

    //取鸡蛋
    public synchronized Object getEgg(){
        while (eggs.size() ==0){
            try{
                wait();
            }catch (Exception e){

            }
        }
        Object  egg = eggs.get(0);
        eggs.clear();
        notify();//唤醒阻塞队列的某县城到就绪队列
        System.out.println("拿到鸡蛋");
        return egg;
    }

    //放鸡蛋
    public synchronized void putEgg(Object egg){
        while (eggs.size()>0){
            try{
                wait();
            }catch (Exception e){

            }
        }
        eggs.add(egg);//往盘子里面放鸡蛋
        notify();
        System.out.println("放入鸡蛋");

    }

    static class AddThread implements Runnable{

        private Plate plate;

        private Object edd = new Object();

        public AddThread(Plate plate){
            this.plate = plate;
        }

        @Override
        public void run() {
            plate.putEgg(edd);
        }
    }

    static class GetThread implements Runnable{

        private Plate plate;

        public GetThread(Plate plate){
            this.plate=plate;
        }

        @Override
        public void run() {
            plate.getEgg();
        }
    }

    public static void main(String[] args) {
        Plate plate = new Plate();

        for (int i = 0; i < 10; i++) {
            new Thread(new AddThread(plate)).start();
            new Thread(new GetThread(plate)).start();
        }
    }

}

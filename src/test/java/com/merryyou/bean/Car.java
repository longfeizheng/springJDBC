package com.merryyou.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created on 2016/11/8 0008.
 *
 * @author zlf
 * @since 1.0
 */
public class Car implements BeanFactoryAware ,BeanNameAware,InitializingBean,DisposableBean {

    private String brand;
    private String color;
    private int maxSpeed;
    private BeanFactory beanFactory;
    private String beanName;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand()设置属性");
        this.brand = brand;
    }

    public void introduce(){
        System.out.println("bradn:"+brand+";color"+color+"; maxSpeed:"+maxSpeed);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }

    //1、管理Bean生命周期的接口
    public Car(){
        System.out.println("调用Car构造函数");
    }

    //2、BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory=beanFactory;
    }

    //3、BeanNameAware接口方法
    @Override
    public void setBeanName(String name) {
        System.out.println("调用BeanNameAware.setBeanName()");
        this.beanName=beanName;
    }

    //4 InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet()");
    }

    // 5  DisposableBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destroy()");
    }

    // 6  通过<bean>的init-method属性指定的初始化方法
    public void myInit(){
        System.out.println("调用inti-method所指定的myInit(),将maxSpeed设置为240.");
        this.maxSpeed=240;
    }

    //7  通过<bean>的destory-method属性指定的销毁方法
    public void myDestory(){
        System.out.println("调用destory-method所指定的myDestory()方法。");
    }
}

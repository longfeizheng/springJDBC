package com.merryyou.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created on 2016/11/8 0008.
 *
 * @author zlf
 * @since 1.0
 */
public class BeanLifeCycle {
    public static void lifiCycleInBeanFactory() {
        //1 下面两句装载配置文件，并启动容器
        Resource resource = new ClassPathResource("beans.xml");
        BeanFactory bf = new XmlBeanFactory(resource);

        //2 向容器中注册MyBeanPostProcesser处理器
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());
        //3 想容器中注册MyInstantiationAwareBeanPostProcessor后处理器
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        //4 第一次从容器中获取car ,将触发容器实例化该Bean,这将引发Bean生命周期方法的调用
        Car car = (Car) bf.getBean("car");
        car.introduce();
        car.setColor("红色");

        //5 第二次从容器中获取car，直接从缓存池中取（因为 scope="singleton"）
        Car car1 = (Car) bf.getBean("car");

        //6 查看car 和 car1 是否指向同一个引用
        System.out.println("car == car1 " +(car == car1));

        //7 关闭容器
        ((ConfigurableBeanFactory) bf).destroySingletons();

    }

    public static void main(String[] args) {
        lifiCycleInBeanFactory();
    }
}

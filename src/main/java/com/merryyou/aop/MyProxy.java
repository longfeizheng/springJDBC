package com.merryyou.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created on 2016/3/22 0022.
 *
 * @author zlf
 * @since 1.0
 */
public class MyProxy implements InvocationHandler {

    private Object targetObject;

    public Object createProxyInstance(Object targetObject){
        this.targetObject = targetObject;

        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        command();;

        Object ret = method.invoke(targetObject,args);

        award();

        return ret;
    }

    public void command(){
        System.out.println("驯兽师发出命令！");
    }

    public void award(){
        System.out.println("驯兽师给予奖励！");
    }
}

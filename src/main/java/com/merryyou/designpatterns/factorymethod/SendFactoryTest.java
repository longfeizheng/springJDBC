package com.merryyou.designpatterns.factorymethod;

/**
 * Created on 2016/5/31 0031.
 *
 * @author zlf
 * @since 1.0
 * 工厂模式适合：凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建。
 * 在以上的三种模式中，第一种如果传入的字符串有误，不能正确创建对象，第三种相对于第二种，
 * 不需要实例化工厂类，所以，大多数情况下，我们会选用第三种——静态工厂方法模式。
 */
public class SendFactoryTest {
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.product("sms");
        sender.Send();
        System.out.println("---------------------------------");
        Sender sms = SendFactory.productSms();
        sms.Send();

    }
}

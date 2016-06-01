package com.merryyou.designpatterns.factorymethod;

/**
 * Created on 2016/5/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class SendFactory {
    public Sender product (String type){
        if("mail".equals(type)){
            return new MailSender();
        }else if("sms".equals(type)){
            return new SmsSender();
        }else{
            System.out.println("请输入正确类型");
            return null;
        }
    }

    /**
     * 静态工厂方法模式。
     * @return
     */
    public static Sender productMail(){
        return new MailSender();
    }

    /**
     * 静态工厂方法模式。
     * @return
     */
    public static Sender productSms(){
        return new SmsSender();
    }
}

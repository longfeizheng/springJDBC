package com.merryyou.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created on 2016/10/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class Test08 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.merryyou.reflect.Person01");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("=====本类属性======");
        Field[] fields = demo.getDeclaredFields();//返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段。
        for(int i=0;i<fields.length;i++){
            //权限修饰符
            int mo = fields[i].getModifiers();
            String priv = Modifier.toString(mo);
            //属性类型
            Class<?> type = fields[i].getType();
            System.out.println(priv+" "+type.getName()+" "+fields[i].getName());
        }
    }
}

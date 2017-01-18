package com.merryyou.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * Created on 2016/10/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class Test06 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.merryyou.reflect.Person01");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<?>[] cons = demo.getConstructors();//返回一个包含某些 Constructor 对象的数组，这些对象反映此 Class 对象所表示的类的所有公共构造方法。
        for(int i =0;i<cons.length;i++){
            Class types[] = cons[i].getParameterTypes();//按照声明顺序返回一组 Class 对象，这些对象表示此 Constructor 对象所表示构造方法的形参类型。
            System.out.print("构造方法");
            int mo = cons[i].getModifiers();//以整数形式返回此 Constructor 对象所表示构造方法的 Java 语言修饰符。
            System.out.print(Modifier.toString(mo)+" ");
            System.out.print(cons[i].getName());//以字符串形式返回此构造方法的名称。
            System.out.print("(");
            for(int j=0;j<types.length;j++){
                System.out.println(types[j].getName()+"args");//以 String 的形式返回此 Class 对象所表示的实体（类、接口、数组类、基本类型或 void）名称。
                if(j<types.length-1){
                    System.out.print(",");
                }
            }
            System.out.println("){}");
        }
    }
}

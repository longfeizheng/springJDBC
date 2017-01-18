package com.merryyou.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created on 2016/10/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class Test07 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.merryyou.reflect.Person01");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] methods = demo.getMethods();//返回一个包含某些 Method 对象的数组，
        for(int i=0;i<methods.length;i++){
            Class<?> returnType = methods[i].getReturnType();//返回一个 Class 对象，该对象描述了此 Method 对象所表示的方法的正式返回类型。
            Class<?> para[] = methods[i].getParameterTypes();//按照声明顺序返回 Class 对象的数组，这些对象描述了此 Method 对象所表示的方法的形参类型。
            int temp = methods[i].getModifiers();//以整数形式返回此 Method 对象所表示方法的 Java 语言修饰符。
            System.out.print(Modifier.toString(temp)+" ");
            System.out.print(returnType.getName()+" ");
            System.out.print(methods[i].getName()+" ");
            System.out.print("(");
            for(int j=0;j<para.length;j++){
                System.out.print(para[j].getName()+" "+"args"+j);
                if(j<para.length-1){
                    System.out.print(",");
                }
            }
            Class<?> exec[] = methods[i].getExceptionTypes();// 返回 Class 对象的数组，这些对象描述了声明将此 Method 对象表示的底层方法抛出的异常类型。
            if(exec.length>0){
                System.out.print(") throws ");
                for(int k=0;k<exec.length;k++){
                    System.out.print(exec[k].getName()+" ");
                    if(k<exec.length-1){
                        System.out.print(",");
                    }
                }
            }else{
                System.out.print(")");
            }
            System.out.println();
        }
    }
}

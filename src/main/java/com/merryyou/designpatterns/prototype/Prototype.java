package com.merryyou.designpatterns.prototype;

import java.io.*;

/**
 * Created on 2016/5/31 0031.
 *
 * @author zlf
 * @since 1.0
 *
 * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
    深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。

要实现深复制，需要采用流的形式读入当前对象的二进制输入，再写出二进制数据对应的对象。
 */
public class Prototype implements Cloneable,Serializable{


    private static final long serialVersionUID = -4644185978637818950L;

    /**
     * 浅复制
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException{
        Prototype proto = (Prototype) super.clone();
        return proto;
    }

    /**
     * 深复制
     * @return
     * @throws Exception
     */
    public Object deepClone() throws Exception{

        //写入当前对象的二进制流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        //读取二进制流产生的新对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();

    }
}

package com.merryyou.test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created on 2016/9/16 0016.
 *
 * @author zlf
 * @since 1.0
 */
public class UseFileOutputStream {
    public static void main(String[] args){
        byte buf[] = new byte[255];
        byte bufIn[] = new byte[255];
        try{
            String str = "你好，这是已有的文本";
            buf = str.getBytes();
            //创建文件输出流对象
            FileOutputStream fileOut = new FileOutputStream("HelloWorld.txt");
            //写入文件
            fileOut.write(buf,0,buf.length);
            fileOut.flush();
            fileOut.close();
            System.out.println("\n请输入一行文本：");
            //从键盘接收文本
            int bytes = System.in.read(bufIn,0,255);
            //追加文本
            fileOut = new FileOutputStream("HelloWorld.txt",true);
            fileOut.write(bufIn,0,bytes);
//            fileOut.flush();
//            fileOut.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());}}
}

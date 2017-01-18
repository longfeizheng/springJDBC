package com.merryyou.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created on 2016/11/15 0015.
 *
 * @author zlf
 * @since 1.0
 */
public class FileCopy {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024*3];   //一次取出的字节数大小,缓冲区大小
        int numberRead = 0;
        try (FileInputStream input = new FileInputStream("C:/Users/Administrator/Desktop/javase_io.jpg");
             FileOutputStream out = new FileOutputStream("C:/Users/Administrator/Desktop/javase_io1.jpg")) {
            //如果文件不存在会自动创建
            while ((numberRead = input.read(buffer)) != -1) {  //numberRead的目的在于防止最后一次读取的字节小于buffer长度，
                out.write(buffer, 0, numberRead);       //否则会自动被填充0
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}
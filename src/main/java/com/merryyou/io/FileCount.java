package com.merryyou.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created on 2016/11/15 0015.
 *
 * @author zlf
 * @since 1.0
 */
public class FileCount {
    /**
     * 我们写一个检测文件长度的小程序，利用Try-Catch-Finally管理资源
     */
    public static void main(String[] args) {
        int count = 0;  //统计文件字节长度
        try(InputStream stream = new FileInputStream(new File("C:/Users/Administrator/Desktop/javase_io.jpg"))) {
          /*1.new File()里面的文件地址也可以写成D:\\David\\Java\\java 高级进阶\\files\\tiger.jpg,前一个\是用来对后一个
          */
            while (stream.read() != -1) {  //读取文件字节，并递增指针到下一个字节
                count++;
            }
            System.out.println("---长度是： " + count + " 字节");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
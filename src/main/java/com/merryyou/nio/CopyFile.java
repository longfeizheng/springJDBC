package com.merryyou.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created on 2016/6/1 0001.
 *
 * @author zlf
 * @since 1.0
 */
public class CopyFile {
    public static void main(String[] args) throws Exception{

        String infile = "C:\\Users\\Administrator\\Desktop\\1.sql";
        String outfile ="C:\\Users\\Administrator\\Desktop\\1.txt";

        FileInputStream fin = new FileInputStream(infile);
        FileOutputStream fout = new FileOutputStream(outfile);

        //获取输入输出通道
        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();

        //创建1024字节的缓存区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(true){
            //clear 方法重设缓冲区，使它可以接受读入的数据
            buffer.clear();
            //从输入通道中将数据读到缓冲区
            int r = fcin.read(buffer);

            //read 方法返回读取的字节数，可能为零，如果该通道已经达流的末尾，则返回-1
            if(r==-1){
                break;
            }
            //flip方法让缓冲区可以将新读入的数据写入另一个通道
            buffer.flip();
            //从输出通道中奖数据写入缓冲区
            fcout.write(buffer);
        }
    }
}

package com.merryyou.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URI;

/**
 * Created on 2016/1/16 0016.
 *
 * @author zlf
 * @since 1.0
 */
public class HDFSDemo {

    FileSystem fs = null;


    @Before
    public void init() throws Exception{
        fs = FileSystem.get(new URI("hdfs://192.168.1.103:9000"),new Configuration(),"root");
    }

    @Test
    public void testDown() throws Exception{
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.1.103:9000"),new Configuration());
        InputStream in =fs.open(new Path("/words"));
        OutputStream out = new FileOutputStream("F://hadoop/words");
        IOUtils.copyBytes(in, out, 4096, true);
    }
    @Test
    public void testUp() throws Exception{
        //读取本地文件系统的文件
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.1.103:9000"),new Configuration(),"root");
        InputStream in = new FileInputStream("c://fzyz.dll");
        OutputStream out = fs.create(new Path("/test.jar"));
        IOUtils.copyBytes(in,out,4096,true);
    }

    @Test
    public void testDownLoad() throws Exception{
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.1.103:9000"),new Configuration());
       // fs.copyToLocalFile(new Path("/jdk"),new Path("F://hadoop/jkdk"));
    }

    @Test
    public void testDelete() throws Exception{
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.1.103:9000"),new Configuration(),"root");
       boolean flag= fs.delete(new Path("/test.jar"),false); //递归删除  后面的boolean值为true
        System.out.println(flag);
    }

    @Test void testMkdir() throws Exception{
        fs.mkdirs(new Path("/test"));
    }
}

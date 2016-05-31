package com.merryyou.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created on 2016/1/25 0025.
 *
 * @author zlf
 * @since 1.0
 */
public class WordCount {
    public static void main(String[] args) throws Exception {
       //构建一个job对象
        Job job = Job.getInstance(new Configuration());

        //注意:
        job.setJarByClass(WordCount.class);

        //设置mapper相关属性
        job.setMapperClass(WCMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);
        FileInputFormat.setInputPaths(job,new Path("/words.txt"));

        //设置reducer相关属性
        job.setReducerClass(WCReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        FileOutputFormat.setOutputPath(job,new Path("/wcout0125"));
        //提交任务
        job.waitForCompletion(true);
    }



}

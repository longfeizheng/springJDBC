package com.merryyou.hadoop;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created on 2016/1/25 0025.
 *
 * @author zlf
 * @since 1.0
 */
public class WCMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //super.map(key, value, context);
        //接收数据v1
        String line = value.toString();
        //切分数据
        String[] words = line.split(" ");
        //循环
        for (String w : words) {
            //出现一次记一个 一  输出
            context.write(new Text(w),new LongWritable(1));
        }
    }
}

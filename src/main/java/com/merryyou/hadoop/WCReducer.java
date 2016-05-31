package com.merryyou.hadoop;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created on 2016/1/25 0025.
 *
 * @author zlf
 * @since 1.0
 */
public class WCReducer extends Reducer<Text, LongWritable, Text, LongWritable> {
    @Override
    protected void reduce(Text key, Iterable<LongWritable> v2s, Context context) throws IOException, InterruptedException {
        //super.reduce(key, values, context);
        //接收数据
        //Text k3 = k2;
        //定义一个计数器
        long counter = 0;
        //循环 v2s

        for (LongWritable i : v2s) {
            counter += i.get();
        }
        //输出
        context.write(key,new LongWritable(counter));
    }
}

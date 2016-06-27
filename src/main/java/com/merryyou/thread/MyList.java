package com.merryyou.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2016/6/12 0012.
 *
 * @author zlf
 * @since 1.0
 */
public class MyList {
    private static List list = new ArrayList<>();
    public static void add(){
        list.add("郑龙飞");
    }
    public static int size(){
        return list.size();
    }

}

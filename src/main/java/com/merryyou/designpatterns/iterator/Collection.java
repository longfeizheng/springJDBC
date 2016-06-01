package com.merryyou.designpatterns.iterator;

/**
 * Created on 2016/5/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public interface Collection {

    public Iterator iterator();

    //取得结合元素
    public Object get(int i);

    //取得集合大小
    public int size();
}

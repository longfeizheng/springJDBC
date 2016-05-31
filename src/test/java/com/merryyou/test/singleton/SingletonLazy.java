package com.merryyou.test.singleton;

/**
 * Created on 2016/2/14 0014.
 *
 * @author zlf
 * @since 1.0
 */
public class SingletonLazy {
    private SingletonLazy() {
    }

    ;//私有化构造方法
    private static SingletonLazy s = null;

    private static SingletonLazy getInstance() {
        if (null == s) { //只有s为空的时候才进入，提高效率
            synchronized (SingletonLazy.class) { //锁住 ，不允许其它线程操作s 会导致产生两个对象
                if (null == s) {
                    s = new SingletonLazy();
                }
            }
        }
        return s;
    }
}

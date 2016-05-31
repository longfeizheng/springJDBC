package com.merryyou.java8.interfac;

import java.util.function.Supplier;

/**
 * Created on 2016/5/28 0028.
 *
 * @author zlf
 * @since 1.0
 */
public interface DefaulableFactory {
    static Defaulable create(Supplier<Defaulable> supplier){
        return supplier.get();
    }
}

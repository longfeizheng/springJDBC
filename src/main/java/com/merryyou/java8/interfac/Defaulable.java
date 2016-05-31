package com.merryyou.java8.interfac;

/**
 * Created on 2016/5/28 0028.
 *
 * @author zlf
 * @since 1.0
 */
public interface Defaulable {
    default String notRequired(){
        return "default implementation";
    }
}

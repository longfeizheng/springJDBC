package com.merryyou.util;

import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;

/**
 * Created on 2015/9/15 0015.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public class BeanUtils {
    private BeanUtils() {
    }

    /**
     * Copy non null properties.
     *
     * @param dest the dest
     * @param orig the orig
     */
    public static void copyNonNullProperties(Object dest, Object orig) {
        BeanUtilsBean notNull = new NullAwareBeanUtilsBean();

        try {
            notNull.copyProperties(dest, orig);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

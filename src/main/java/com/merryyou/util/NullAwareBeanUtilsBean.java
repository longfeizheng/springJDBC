package com.merryyou.util;

import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;

/**
 * Created on 2015/9/15 0015.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public class NullAwareBeanUtilsBean extends BeanUtilsBean {

    @Override
    public void copyProperty(Object dest, String name, Object value)
            throws IllegalAccessException, InvocationTargetException {
        if (value == null) {
            return;
        }

        super.copyProperty(dest, name, value);
    }
}


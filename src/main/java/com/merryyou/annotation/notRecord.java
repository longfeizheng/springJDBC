package com.merryyou.annotation;

import java.lang.annotation.*;

/**
 * Created on 2016/10/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface notRecord {
}

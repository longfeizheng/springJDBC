package com.merryyou.annotation;

import java.lang.annotation.*;

/**
 * Created on 2016/9/9 0009.
 *
 * @author zlf
 * @since 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}

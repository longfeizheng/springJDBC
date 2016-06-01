package com.merryyou.designpatterns.interpreter;

/**
 * Created on 2016/6/1 0001.
 *
 * @author zlf
 * @since 1.0
 */
public interface Expression {
    public int interpret(Context context);
}

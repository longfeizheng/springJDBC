package com.merryyou.annotation;

/**
 * Created on 2016/10/31 0031.
 *
 * @author zlf
 * @since 1.0
 */
public class NumException extends Exception {
    private String name;

    public NumException(String message) {
        this.name = message;
    }

    public NumException(Throwable cause, String name) {
        super(name, cause);
        this.name = name;
    }

    public String toString(){
        return name;
    }
}

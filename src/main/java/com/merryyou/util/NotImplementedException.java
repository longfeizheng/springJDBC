package com.merryyou.util;

/**
 * Created on 2015/9/15 0015.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public class NotImplementedException extends UnsupportedOperationException {

    private static final long serialVersionUID = -7782497437946093102L;


    /**
     * Instantiates a new Not implemented exception.
     *
     * @param message the message
     */
    public NotImplementedException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Not implemented exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public NotImplementedException(String message, Throwable cause) {
        super(message, cause);
    }
}
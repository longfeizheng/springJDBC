package com.merryyou.util;

/**
 * Created on 2015/9/22 0022.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public enum Status {

    /**
     * The UNKNOWN.
     */
    UNKNOWN(-1),

    /**
     * The AVAILABLE.
     */
    AVAILABLE(1),

    /**
     * The NOT_AVAILABLE.
     */
    NOT_AVAILABLE(0);


    private final int code;

    /**
     * Instantiates a new Status.
     *
     * @param code the code
     */
    Status(int code) {
        this.code = code;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }


    /**
     * From code.
     *
     * @param code the code
     * @return the status
     */
    public static Status fromCode(int code) {
        for (Status type : Status.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }

        return UNKNOWN;
    }
}

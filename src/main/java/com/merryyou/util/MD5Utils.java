package com.merryyou.util;

import org.springframework.util.DigestUtils;

/**
 * Created on 2015/9/17 0017.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public final class MD5Utils {
    /**
     * Get mD 5 of str as hex.
     *
     * @param str the str
     * @return the string
     */
    public static String getMD5ofStrAsHex(String str) {
        return getMD5ofBytesAsHex(str.getBytes());
    }

    /**
     * Get mD 5 of bytes as hex.
     *
     * @param bytes the bytes
     * @return the string
     */
    public static String getMD5ofBytesAsHex(byte[] bytes) {
        return DigestUtils.md5DigestAsHex(bytes);
    }

    /**
     * Get mD 5 of str.
     *
     * @param str the str
     * @return the byte [ ]
     */
    public static byte[] getMD5ofStr(String str) {
        return getMD5ofBytes(str.getBytes());
    }

    /**
     * Get mD 5 of bytes.
     *
     * @param bytes the bytes
     * @return the byte [ ]
     */
    public static byte[] getMD5ofBytes(byte[] bytes) {
        return DigestUtils.md5Digest(bytes);
    }

    //test
    public static void main(String[] args){
        System.out.printf(MD5Utils.getMD5ofStrAsHex("123456"));
    }
}

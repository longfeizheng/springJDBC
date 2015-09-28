package com.merryyou.util;

/**
 * Created on 2015/9/22 0022.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public final class HexUtils {

    /**
     * The constant CHAR_MAP_64.
     */
    private static final char[] CHAR_MAP_64;

    static {
        CHAR_MAP_64 = new char[64];
        for (int i = 0; i < 10; i++) {
            CHAR_MAP_64[i] = (char) ('0' + i);
        }
        for (int i = 10; i < 36; i++) {
            CHAR_MAP_64[i] = (char) ('a' + i - 10);
        }
        for (int i = 36; i < 62; i++) {
            CHAR_MAP_64[i] = (char) ('A' + i - 36);
        }
        CHAR_MAP_64[62] = '_';
        CHAR_MAP_64[63] = '-';
    }


    /**
     * Instantiates a new Hex utils.
     */
    private HexUtils() {
    }


    /**
     * Hex to N64.
     *
     * @param hex the hex
     * @return the string of N64.
     */
    public static String hexToN64(String hex) {
        StringBuilder r = new StringBuilder();
        int index;
        int[] buff = new int[3];
        int l = hex.length();
        for (int i = 0; i < l; i++) {
            index = i % 3;
            buff[index] = Integer.parseInt("" + hex.charAt(i), 16);
            if (index == 2) {
                r.append(CHAR_MAP_64[buff[0] << 2 | buff[1] >>> 2]);
                r.append(CHAR_MAP_64[(buff[1] & 3) << 4 | buff[2]]);
            }
        }
        return r.toString();
    }
}

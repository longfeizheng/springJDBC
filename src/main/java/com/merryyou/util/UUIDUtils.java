package com.merryyou.util;

import java.util.UUID;

/**
 * Created on 2015/9/22 0022.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public final class UUIDUtils {

    /**
     * The default separator character.
     */
    public static final String DEFAULT_SEPCHAR = "-";


    /**
     * The private constructor.
     */
    private UUIDUtils() {
    }


    /**
     * To generate a new uuid without the separator character '-'.
     *
     * @return the uuid string in 32 characters. e.g. d59812eef2aa495087a611304eb683be
     */
    public static String generateStr() {
        UUID uuid = generate();
        String rtn = uuid.toString();
        rtn = rtn.replace(DEFAULT_SEPCHAR, "");
        return rtn;
    }


    /**
     * Generate with separator "-".
     *
     * @return the string
     */
    public static String generateStrWithSep() {
        UUID uuid = generate();

        return uuid.toString();
    }

    /**
     * To generate a new uuid.
     *
     * @return the uuid string has full of 36 characters will be returned if the
     * <code>isUsingSepChar</code> is true. In otherwise, The uuid string without four separator
     * which has 32 characters will be returned. e.g. when <code>isUsingSepChar</code> is true,
     * the return string is 46c298fa-b814-4c91-aa88-b68ac7863f91.
     * in other hand, the return string should be 46c298fab8144c91aa88b68ac7863f91
     * when it's false.
     */
    public static UUID generate() {
        return UUID.randomUUID();
    }


    /**
     * Generate a N64 string from UUID string.
     *
     * @return the N64 string.
     */
    public static String generateN64() {
        String uuid = "0" + generateStr();
        return HexUtils.hexToN64(uuid);
    }
}

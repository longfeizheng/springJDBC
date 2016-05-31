package com.merryyou.java8;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created on 2016/5/28 0028.
 *
 * @author zlf
 * @since 1.0
 */
public class Base64Test {
    public static void main(String[] args) {
        final String text = "Base64 finally in Java 8!";
        final String encoded = Base64
                .getEncoder()
                .encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);

        final String decoded = new String(
                Base64.getDecoder().decode(encoded),
                StandardCharsets.UTF_8);
        System.out.println(decoded);
    }
}

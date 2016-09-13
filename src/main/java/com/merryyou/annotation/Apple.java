package com.merryyou.annotation;

/**
 * Created on 2016/9/9 0009.
 *
 * @author zlf
 * @since 1.0
 */
public class Apple {
    @FruitName("Apple")
    private String appleNmae;

    public String getAppleNmae() {
        return appleNmae;
    }

    public void setAppleNmae(String appleNmae) {
        this.appleNmae = appleNmae;
    }

}

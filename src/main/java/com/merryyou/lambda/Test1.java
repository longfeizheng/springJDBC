package com.merryyou.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 2016/3/22 0022.
 *
 * @author zlf
 * @since 1.0
 */
public class Test1 {
    public static void main(String[] args) throws Exception{
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));
    }
}

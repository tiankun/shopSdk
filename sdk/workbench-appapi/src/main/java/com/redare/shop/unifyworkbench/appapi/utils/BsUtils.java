package com.redare.shop.unifyworkbench.appapi.utils;

import org.apache.commons.lang.math.RandomUtils;

public class BsUtils {
    public static String randomInt(int count) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < count; i++) {
            str.append(RandomUtils.nextInt(10));
        }
        return str.toString();
    }
}

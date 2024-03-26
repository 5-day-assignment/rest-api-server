package com.assignment5d.restapiserver.util;

public class StringUtil {

    public static boolean isValid(String input) {
        return input != null && !input.trim().isEmpty();
    }
}

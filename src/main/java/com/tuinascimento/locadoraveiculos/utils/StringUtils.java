package com.tuinascimento.locadoraveiculos.utils;

public class StringUtils {
    public static String removeNonNumeric(String str) {
        return str.replaceAll("[^0-9]", "");
    }
}

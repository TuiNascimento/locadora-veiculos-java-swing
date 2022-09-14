package com.tuinascimento.locadoraveiculos.utils;

public class StringUtils {
    public static String removeNonNumeric(String str) {
        return str.replaceAll("[^0-9]", "");
    }

    //convert a formatted string to a double
    public static double convertToDouble(String str) {
        return Double.parseDouble(str.replaceAll("[^0-9,]", "").replace(",", "."));
    }
}

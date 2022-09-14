package com.tuinascimento.locadoraveiculos.utils;

public class StringUtils {
    public static String removeNonNumeric(String str) {
        return str.replaceAll("[^0-9]", "");
    }

    //convert a formatted string to a double
    public static double convertToDouble(String str) {
        return Double.parseDouble(str.replaceAll("[^0-9,]", "").replace(",", "."));
    }

    public static String formatDoubleWithMonetarySymbol(double value) {
        return String.format("R$ %.2f", value);
    }
}

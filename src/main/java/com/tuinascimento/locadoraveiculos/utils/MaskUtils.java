package com.tuinascimento.locadoraveiculos.utils;

import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class MaskUtils {
    public static MaskFormatter getCpfMask() {
        try {
            return new MaskFormatter("###.###.###-##");
        } catch (Exception e) {
            return null;
        }
    }

    public static NumberFormatter getMonetaryMask() {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
        return new NumberFormatter(format);
    }
}

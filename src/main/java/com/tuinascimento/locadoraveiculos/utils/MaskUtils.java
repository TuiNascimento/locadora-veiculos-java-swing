package com.tuinascimento.locadoraveiculos.utils;

import javax.swing.text.MaskFormatter;

public class MaskUtils {
    public static MaskFormatter getCpfMask() {
        try {
            return new MaskFormatter("###.###.###-##");
        } catch (Exception e) {
            return null;
        }
    }
}

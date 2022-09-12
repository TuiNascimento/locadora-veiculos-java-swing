package com.tuinascimento.locadoraveiculos.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class CpfCnpjUtils {

    public static final String[] INVALID_CPF_SEQUENCES = new String[]{"00000000000", "11111111111", "22222222222", "33333333333", "44444444444", "55555555555", "66666666666", "77777777777", "88888888888", "99999999999"};

    public static boolean validaCpf(String cpf) {
        if (cpf == null) return false;

        cpf = StringUtils.removeNonNumeric(cpf);
        if (cpf.length() != 11) return false;

        try {
            Long.parseLong(cpf);
        } catch (NumberFormatException e) {
            return false;
        }

        for (String invalidSequence : CpfCnpjUtils.INVALID_CPF_SEQUENCES) {
            if (invalidSequence.equals(cpf)) return false;
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        // Calculo do 1o. Digito Verificador
        sm = 0;
        peso = 10;
        for (i = 0; i < 9; i++) {
            // converte o i-esimo caractere do cpf em um numero:
            // por exemplo, transforma o caractere '0' no inteiro 0
            // (48 eh a posicao de '0' na tabela ASCII)
            num = (int) (cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig10 = '0';
        else dig10 = (char) (r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
        sm = 0;
        peso = 11;
        for (i = 0; i < 10; i++) {
            num = (int) (cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig11 = '0';
        else dig11 = (char) (r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
        if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) return true;

        return false;
    }
}

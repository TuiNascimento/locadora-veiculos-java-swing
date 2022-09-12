/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.tuinascimento.locadoraveiculos;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.tuinascimento.locadoraveiculos.view.LocadoraVeiculosMainView;

import javax.swing.*;

/**
 *
 * @author asaas
 */
public class LocadoraVeiculos {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() );
        } catch( Exception ex ) {
            ex.printStackTrace();
        }
        new LocadoraVeiculosMainView().setVisible(true);
    }
}

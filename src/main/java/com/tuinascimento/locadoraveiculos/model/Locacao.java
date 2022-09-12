package com.tuinascimento.locadoraveiculos.model;

import com.tuinascimento.locadoraveiculos.model.cliente.Cliente;

import java.util.Calendar;

public class Locacao {

    private int dias;

    private double valor;

    private Calendar data;

    private Cliente cliente;

    public double getValor() {
        return this.valor;
    }

    public Calendar getData() {
        return this.data;
    }

    public Cliente getCliente() {
        return this.cliente;
    }
}

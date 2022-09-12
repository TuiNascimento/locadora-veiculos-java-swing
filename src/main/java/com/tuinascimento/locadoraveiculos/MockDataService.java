package com.tuinascimento.locadoraveiculos;

import com.tuinascimento.locadoraveiculos.model.cliente.Cliente;

import java.util.ArrayList;

public class MockDataService {
    public static ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("Bill", "184574298", "480.925.180-25", "Rua 1"));
        clientes.add(new Cliente("Fi do Bill", "", "037.780.570-06", "Rua 2"));
        clientes.add(new Cliente("Esposa do Bill", "", "624.760.910-81", ""));

        return clientes;
    }
}

package com.tuinascimento.locadoraveiculos.utils;

import com.tuinascimento.locadoraveiculos.model.automovel.Automovel;
import com.tuinascimento.locadoraveiculos.model.automovel.ModeloAutomovel;
import com.tuinascimento.locadoraveiculos.model.cliente.Cliente;
import com.tuinascimento.locadoraveiculos.model.motocicleta.ModeloMotocicleta;
import com.tuinascimento.locadoraveiculos.model.motocicleta.Motocicleta;
import com.tuinascimento.locadoraveiculos.model.van.ModeloVan;
import com.tuinascimento.locadoraveiculos.model.van.Van;
import com.tuinascimento.locadoraveiculos.model.veiculo.Veiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.CategoriaVeiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.EstadoVeiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.MarcaVeiculo;

import java.util.ArrayList;

public class MockUtils {
    public static ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("Bill", "184574298", "480.925.180-25", "Rua 1"));
        clientes.add(new Cliente("Fi do Bill", "", "037.780.570-06", "Rua 2"));
        clientes.add(new Cliente("Esposa do Bill", "", "624.760.910-81", ""));

        return clientes;
    }

    public static ArrayList<Veiculo> getVeiculos() {
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(new Van(ModeloVan.KOMBI, MarcaVeiculo.VOLKSWAGEN, null, EstadoVeiculo.DISPONIVEL, CategoriaVeiculo.INTERMEDIARIO, 30000.00, "AAA-1111", 2008));
        veiculos.add(new Van(ModeloVan.SPRINTER, MarcaVeiculo.MERCEDES_BENZ, null, EstadoVeiculo.DISPONIVEL, CategoriaVeiculo.INTERMEDIARIO, 50000.00, "BBB-1111", 2015));
        veiculos.add(new Automovel(ModeloAutomovel.FUSCA, MarcaVeiculo.VOLKSWAGEN, null, EstadoVeiculo.DISPONIVEL, CategoriaVeiculo.POPULAR, 10000.00, "CCC-1111", 1970));
        veiculos.add(new Automovel(ModeloAutomovel.GOL, MarcaVeiculo.VOLKSWAGEN, null, EstadoVeiculo.DISPONIVEL, CategoriaVeiculo.POPULAR, 20000.00, "DDD-1111", 2010));
        veiculos.add(new Motocicleta(ModeloMotocicleta.CB_1000, MarcaVeiculo.HONDA, null, EstadoVeiculo.DISPONIVEL, CategoriaVeiculo.POPULAR, 5000.00, "EEE-1111", 2015));

        return veiculos;
    }
}

package com.tuinascimento.locadoraveiculos.model.van;

import com.tuinascimento.locadoraveiculos.model.veiculo.Veiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.CategoriaVeiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.EstadoVeiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.MarcaVeiculo;

public class Van extends Veiculo {

    private ModeloVan modelo;

    public Van(ModeloVan modelo, MarcaVeiculo marca, EstadoVeiculo estado, CategoriaVeiculo categoria, double valorDeCompra, String placa, int ano) {
        super(marca, estado, categoria, valorDeCompra, placa, ano);
        this.modelo = modelo;
    }

    public ModeloVan getModelo() {
        return this.modelo;
    }

    @Override
    public double getValorDiariaLocacao() {
        CategoriaVeiculo categoria = this.getCategoria();
        switch (categoria) {
            case POPULAR:
                return 200.00;
            case INTERMEDIARIO:
                return 400.00;
            case LUXO:
                return 600.00;
            default:
                return 0;
        }
    }
}

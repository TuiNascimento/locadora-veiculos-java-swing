package com.tuinascimento.locadoraveiculos.model.automovel;

import com.tuinascimento.locadoraveiculos.model.Locacao;
import com.tuinascimento.locadoraveiculos.model.veiculo.Veiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.CategoriaVeiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.EstadoVeiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.MarcaVeiculo;

public class Automovel extends Veiculo {

    private ModeloAutomovel modelo;

    public Automovel(ModeloAutomovel modelo, MarcaVeiculo marca, Locacao locacao, EstadoVeiculo estado, CategoriaVeiculo categoria, double valorDeCompra, String placa, int ano) {
        super(marca, locacao, estado, categoria, valorDeCompra, placa, ano);
        this.modelo = modelo;
    }

    public ModeloAutomovel getModelo() {
        return modelo;
    }

    @Override
    public double getValorDiariaLocacao() {
        CategoriaVeiculo categoria = this.getCategoria();
        switch (categoria) {
            case POPULAR:
                return 100.00;
            case INTERMEDIARIO:
                return 300.00;
            case LUXO:
                return 450.00;
            default:
                return 0;
        }
    }
}

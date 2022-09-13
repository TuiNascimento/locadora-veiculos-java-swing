package com.tuinascimento.locadoraveiculos.model.motocicleta;

import com.tuinascimento.locadoraveiculos.model.Locacao;
import com.tuinascimento.locadoraveiculos.model.veiculo.Veiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.CategoriaVeiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.EstadoVeiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.MarcaVeiculo;

public class Motocicleta extends Veiculo {

    private ModeloMotocicleta modelo;

    public Motocicleta(ModeloMotocicleta modelo, MarcaVeiculo marca, Locacao locacao, EstadoVeiculo estado, CategoriaVeiculo categoria, double valorDeCompra, String placa, int ano) {
        super(marca, locacao, estado, categoria, valorDeCompra, placa, ano);
        this.modelo = modelo;
    }

    public ModeloMotocicleta getModelo() {
        return this.modelo;
    }

    @Override
    public double getValorDiariaLocacao() {
        CategoriaVeiculo categoria = this.getCategoria();
        switch (categoria) {
            case POPULAR:
                return 70.00;
            case INTERMEDIARIO:
                return 200.00;
            case LUXO:
                return 350.00;
            default:
                return 0;
        }
    }
}

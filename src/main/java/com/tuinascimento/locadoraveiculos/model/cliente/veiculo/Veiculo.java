package com.tuinascimento.locadoraveiculos.model.cliente.veiculo;

import com.tuinascimento.locadoraveiculos.model.cliente.Cliente;
import com.tuinascimento.locadoraveiculos.model.cliente.veiculo.enums.CategoriaVeiculo;
import com.tuinascimento.locadoraveiculos.model.cliente.veiculo.enums.EstadoVeiculo;
import com.tuinascimento.locadoraveiculos.model.cliente.veiculo.enums.MarcaVeiculo;

import java.util.Calendar;

public abstract class Veiculo  implements VeiculoI{

    private MarcaVeiculo marca;

    private EstadoVeiculo estado;

    private CategoriaVeiculo categoria;

    private double valorDeCompra;

    private String placa;

    private int ano;

    public Veiculo(MarcaVeiculo marca, EstadoVeiculo estado, CategoriaVeiculo categoria, double valorDeCompra, String placa, int ano) {
        this.marca = marca;
        this.estado = estado;
        this.categoria = categoria;
        this.valorDeCompra = valorDeCompra;
        this.placa = placa;
        this.ano = ano;
    }

    @Override
    public void locar(int dias, Calendar data, Cliente cliente) {

    }

    @Override
    public void vender() {

    }

    @Override
    public void devolver() {

    }

    @Override
    public EstadoVeiculo getEstado() {
        return null;
    }

    @Override
    public MarcaVeiculo getMarca() {
        return null;
    }

    @Override
    public CategoriaVeiculo getCategoria() {
        return null;
    }

    @Override
    public String getPlaca() {
        return null;
    }

    @Override
    public int getAno() {
        return 0;
    }

    @Override
    public double getValorParaVenda() {
        return 0;
    }

    @Override
    public double getValorDiariaLocacao() {
        return 0;
    }
}

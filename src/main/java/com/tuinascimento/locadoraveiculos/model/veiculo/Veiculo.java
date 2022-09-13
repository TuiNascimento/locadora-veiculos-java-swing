package com.tuinascimento.locadoraveiculos.model.veiculo;

import com.tuinascimento.locadoraveiculos.model.Locacao;
import com.tuinascimento.locadoraveiculos.model.cliente.Cliente;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.CategoriaVeiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.EstadoVeiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.MarcaVeiculo;

import java.util.Calendar;

public abstract class Veiculo implements VeiculoI {

    private MarcaVeiculo marca;

    private EstadoVeiculo estado;

    private Locacao locacao;

    private CategoriaVeiculo categoria;

    private double valorDeCompra;

    private String placa;

    private int ano;

    public Veiculo(MarcaVeiculo marca, Locacao locacao, EstadoVeiculo estado, CategoriaVeiculo categoria, double valorDeCompra, String placa, int ano) {
        this.marca = marca;
        this.locacao = locacao;
        this.estado = estado;
        this.categoria = categoria;
        this.valorDeCompra = valorDeCompra;
        this.placa = placa;
        this.ano = ano;
    }

    public int calculaIdade() {
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        return anoAtual - this.ano;
    }

    @Override
    public void locar(int dias, Calendar data, Cliente cliente) {
        if (this.estado.isLocado()) return;

        this.locacao = new Locacao(dias, getValorDiariaLocacao(), data, cliente);
        this.estado = EstadoVeiculo.LOCADO;
    }

    @Override
    public void vender() {
        this.estado = EstadoVeiculo.VENDIDO;
    }

    @Override
    public void devolver() {
        this.estado = EstadoVeiculo.DISPONIVEL;
        this.locacao = null;
    }

    @Override
    public EstadoVeiculo getEstado() {
        return this.estado;
    }

    @Override
    public MarcaVeiculo getMarca() {
        return this.marca;
    }

    @Override
    public CategoriaVeiculo getCategoria() {
        return this.categoria;
    }

    @Override
    public Locacao getLocacao() {
        return this.locacao;
    }

    @Override
    public String getPlaca() {
        return this.placa;
    }

    @Override
    public int getAno() {
        return this.ano;
    }

    @Override
    public double getValorParaVenda() {
        double valorParaVenda = this.valorDeCompra - (calculaIdade() * 0.15 * this.valorDeCompra);
        double valorMinimo = this.valorDeCompra * 0.1;

        if (valorParaVenda > 0 || valorParaVenda > (valorMinimo)) return valorParaVenda;

        return valorMinimo;
    }

    @Override
    public abstract double getValorDiariaLocacao();
}

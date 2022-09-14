package com.tuinascimento.locadoraveiculos.model.veiculo;

import com.tuinascimento.locadoraveiculos.model.veiculo.enums.EstadoVeiculo;

import java.util.ArrayList;

public class VeiculoDAO {

    private static VeiculoDAO instance;

    private ArrayList<Veiculo> veiculos;

    private VeiculoDAO() {
        this.veiculos = new ArrayList<>();
    }

    public static VeiculoDAO getInstance() {
        if (instance == null) {
            instance = new VeiculoDAO();
        }
        return instance;
    }
    public void save(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public Veiculo findByPlaca(String placa) {
        for (Veiculo veiculo : this.veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public ArrayList<Veiculo> findByEstado(EstadoVeiculo estado) {
        ArrayList<Veiculo> veiculosFiltrados = new ArrayList<>();

        for (Veiculo veiculo : this.veiculos) {
            if (veiculo.getEstado().equals(estado)) {
                veiculosFiltrados.add(veiculo);
            }
        }
        return veiculosFiltrados;
    }
}

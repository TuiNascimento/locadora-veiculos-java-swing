package com.tuinascimento.locadoraveiculos.model.veiculo;

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
        veiculos.add(veiculo);
    }

    public Veiculo findByPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }
}

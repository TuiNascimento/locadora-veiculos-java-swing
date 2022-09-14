package com.tuinascimento.locadoraveiculos.model.veiculo;

import java.util.ArrayList;

public class VeiculoDAO {

    private ArrayList<Veiculo> veiculos;

    public VeiculoDAO() {
        this.veiculos = new ArrayList<>();
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

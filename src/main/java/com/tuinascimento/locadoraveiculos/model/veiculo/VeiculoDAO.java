package com.tuinascimento.locadoraveiculos.model.veiculo;

import com.tuinascimento.locadoraveiculos.model.veiculo.enums.CategoriaVeiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.EstadoVeiculo;
import com.tuinascimento.locadoraveiculos.utils.MockUtils;

import java.util.ArrayList;
import java.util.Map;

public class VeiculoDAO {

    private static VeiculoDAO instance;

    private ArrayList<Veiculo> veiculos;

    private VeiculoDAO() {
        this.veiculos = new ArrayList<>();
        this.veiculos.addAll(MockUtils.getVeiculos());
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

    public ArrayList<Veiculo> query(Map<String, Object> filters) {
        ArrayList<Veiculo> result = this.veiculos;
        if (filters != null) {
            if (filters.containsKey("tipo")) {
                result.removeIf(veiculo -> veiculo.getTipo() != filters.get("tipo"));
            }
            if (filters.containsKey("placa")) {
                result.removeIf(veiculo -> !veiculo.getPlaca().equals(filters.get("placa")));
            }
            if (filters.containsKey("marca")) {
                result.removeIf(veiculo -> !veiculo.getMarca().equals(filters.get("marca")));
            }
            if (filters.containsKey("modelo")) {
                result.removeIf(veiculo -> !veiculo.getModelo().equals(filters.get("modelo")));
            }
            if (filters.containsKey("categoria")) {
                result.removeIf(veiculo -> veiculo.getCategoria() != filters.get("categoria"));
            }
            if (filters.containsKey("ano")) {
                result.removeIf(veiculo -> veiculo.getAno() != ((double) filters.get("ano")));
            }
            if (filters.containsKey("valorDiariaLocacao")) {
                result.removeIf(veiculo -> veiculo.getValorDiariaLocacao() != ((double) filters.get("valorDiariaLocacao")));
            }
        }

        return result;
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

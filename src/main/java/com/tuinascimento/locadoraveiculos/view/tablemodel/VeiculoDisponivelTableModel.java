package com.tuinascimento.locadoraveiculos.view.tablemodel;

import com.tuinascimento.locadoraveiculos.model.veiculo.Veiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.VeiculoDAO;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.EstadoVeiculo;
import com.tuinascimento.locadoraveiculos.utils.StringUtils;

import javax.swing.table.AbstractTableModel;
import java.util.HashMap;
import java.util.Map;

public class VeiculoDisponivelTableModel extends AbstractTableModel {

    private final String[] campos = {"Placa", "Marca", "Modelo", "Ano", "Preço da diária"};

    private Map<String, Object> filters;

    public VeiculoDisponivelTableModel() {
    }

    public void setFilters(Map<String, Object> newFilters) {
        HashMap<String, Object> newFiltersCopy = new HashMap<>(newFilters);
        Map<String, Object> filter = Map.of("estado", (Object) EstadoVeiculo.DISPONIVEL);
        newFiltersCopy.putAll(filter);

        this.filters = newFiltersCopy;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.campos[columnIndex];
    }

    @Override
    public int getRowCount() {
        return VeiculoDAO.getInstance().query(this.filters).size();
    }

    @Override
    public int getColumnCount() {
        return this.campos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veiculo veiculo = VeiculoDAO.getInstance().query(this.filters).get(rowIndex);

        switch (columnIndex) {
            case 0:
                return veiculo.getPlaca();
            case 1:
                return veiculo.getMarca();
            case 2:
                return veiculo.getModelo();
            case 3:
                return veiculo.getAno();
            case 4:
                return StringUtils.formatDoubleWithMonetarySymbol(veiculo.getValorDiariaLocacao());
            default:
                return null;
        }
    }
}

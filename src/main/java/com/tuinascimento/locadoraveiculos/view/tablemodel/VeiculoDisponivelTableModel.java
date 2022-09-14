package com.tuinascimento.locadoraveiculos.view.tablemodel;

import com.tuinascimento.locadoraveiculos.model.cliente.ClienteDAO;
import com.tuinascimento.locadoraveiculos.model.veiculo.Veiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.VeiculoDAO;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.EstadoVeiculo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class VeiculoDisponivelTableModel extends AbstractTableModel {

    private final String[] campos = {"Placa", "Marca", "Modelo", "Ano", "Preço da diária"};

    public VeiculoDisponivelTableModel() {
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.campos[columnIndex];
    }


    @Override
    public int getRowCount() {
        return VeiculoDAO.getInstance().findByEstado(EstadoVeiculo.DISPONIVEL).size();
    }

    @Override
    public int getColumnCount() {
        return this.campos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veiculo veiculo = VeiculoDAO.getInstance().findByEstado(EstadoVeiculo.DISPONIVEL).get(rowIndex);

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
                return veiculo.getValorDiariaLocacao();
            default:
                return null;
        }
    }
}

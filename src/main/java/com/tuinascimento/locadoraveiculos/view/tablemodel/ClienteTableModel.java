package com.tuinascimento.locadoraveiculos.view.tablemodel;

import com.tuinascimento.locadoraveiculos.model.cliente.Cliente;
import com.tuinascimento.locadoraveiculos.model.cliente.ClienteDAO;

import javax.swing.table.AbstractTableModel;

public class ClienteTableModel extends AbstractTableModel {

    private final String[] campos = {"Nome", "RG", "CPF", "Endereço"};

    private ClienteDAO clienteDAO;

    public ClienteTableModel(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.campos[columnIndex];
    }

    @Override
    public int getRowCount() {
        return this.clienteDAO.getAllClientes().size();
    }

    @Override
    public int getColumnCount() {
        return this.campos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = this.clienteDAO.getAllClientes().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return cliente.getNome();
            case 1:
                return cliente.getRg();
            case 2:
                return cliente.getCpf();
            case 3:
                return cliente.getEndereco();
            default:
                return null;
        }
    }
}

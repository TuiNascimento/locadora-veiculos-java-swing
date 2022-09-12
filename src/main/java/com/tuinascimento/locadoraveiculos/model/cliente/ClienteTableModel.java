/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuinascimento.locadoraveiculos.model.cliente;

import com.tuinascimento.locadoraveiculos.utils.MockUtils;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 *
 * @author asaas
 */
public class ClienteTableModel extends AbstractTableModel{

    private ArrayList<Cliente> clientes;

    private final String[] campos = {"Nome", "RG", "CPF", "Endereço"};

    public ClienteTableModel() {
        this.clientes = new ArrayList<>();

        for (Cliente cliente : MockUtils.getClientes()) {
            this.clientes.add(cliente);
        }
    }

    public void adicionaCliente(Cliente cliente) {
        this.clientes.add(cliente);
        this.fireTableDataChanged();
    }

    public Cliente getCliente(int linha) {
        return this.clientes.get(linha);
    }

    public void removeCliente(int indiceCliente) {
        this.clientes.remove(indiceCliente);
        this.fireTableRowsDeleted(indiceCliente, indiceCliente);
    }

    public void atualizaCliente(int linha, Cliente clienteAtualizado) {
        Cliente clienteOriginal = this.clientes.get(linha);

        clienteOriginal.setNome(clienteAtualizado.getNome());
        clienteOriginal.setRg(clienteAtualizado.getRg());
        clienteOriginal.setCpf(clienteAtualizado.getCpf());
        clienteOriginal.setEndereco(clienteAtualizado.getEndereco());
        this.fireTableDataChanged();
    }

    public Cliente getClienteByUniqueFields(String name, String rg, String cpf) {
        for (Cliente cliente : this.clientes) {
            if (name.equals(cliente.getNome()) || cpf.equals(cliente.getCpf()) || (!rg.isEmpty() && rg.equals(cliente.getRg()))) {

                return cliente;
            }
        }

        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.campos[columnIndex];
    }

    @Override
    public int getRowCount() {
        return this.clientes.size();
    }

    @Override
    public int getColumnCount() {
        return this.campos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = this.clientes.get(rowIndex);
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

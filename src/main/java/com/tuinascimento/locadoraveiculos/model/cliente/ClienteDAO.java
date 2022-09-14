/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuinascimento.locadoraveiculos.model.cliente;

import com.tuinascimento.locadoraveiculos.utils.MockUtils;

import java.util.ArrayList;

/**
 *
 * @author asaas
 */
public class ClienteDAO {

    private static ClienteDAO instance;

    private ArrayList<Cliente> clientes;

    private final String[] campos = {"Nome", "RG", "CPF", "Endereço"};
    private ClienteDAO() {
        this.clientes = new ArrayList<>();

        this.clientes.addAll(MockUtils.getClientes());
    }
    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    public ArrayList<Cliente> getAllClientes() {
        return this.clientes;
    }
    public void adicionaCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public Cliente getCliente(int linha) {
        return this.clientes.get(linha);
    }

    public void removeCliente(int indiceCliente) {
        this.clientes.remove(indiceCliente);
    }

    public void atualizaCliente(int linha, Cliente clienteAtualizado) {
        Cliente clienteOriginal = this.clientes.get(linha);

        clienteOriginal.setNome(clienteAtualizado.getNome());
        clienteOriginal.setRg(clienteAtualizado.getRg());
        clienteOriginal.setCpf(clienteAtualizado.getCpf());
        clienteOriginal.setEndereco(clienteAtualizado.getEndereco());
    }

    public Cliente getClienteByUniqueFields(String name, String rg, String cpf) {
        for (Cliente cliente : this.clientes) {
            if (name.equals(cliente.getNome()) || cpf.equals(cliente.getCpf()) || (!rg.isEmpty() && rg.equals(cliente.getRg()))) {

                return cliente;
            }
        }

        return null;
    }
}

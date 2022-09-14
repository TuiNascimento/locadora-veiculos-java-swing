package com.tuinascimento.locadoraveiculos.controller;

import com.tuinascimento.locadoraveiculos.model.cliente.Cliente;
import com.tuinascimento.locadoraveiculos.model.cliente.ClienteDAO;
import com.tuinascimento.locadoraveiculos.view.LocadoraVeiculosMainView;

public class LocarVeiculoController {

    private LocadoraVeiculosMainView view;

    public LocarVeiculoController(LocadoraVeiculosMainView view) {
        this.view = view;
    }

    public void init() {
        populaChoiceClientes();

        this.view.jTextFieldFiltroNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtraChoiceClientes();
            }
        });

        this.view.jFormattedTextFieldFiltroCpf.addPropertyChangeListener(e -> filtraChoiceClientes());
    }

    private void populaChoiceClientes() {
        this.view.jChoiceCliente.removeAll();

        for (Cliente cliente : ClienteDAO.getInstance().getAllClientes()) {
            this.view.jChoiceCliente.add(cliente.getNome());
        }
    }

    private void filtraChoiceClientes() {
        this.view.jChoiceCliente.removeAll();

        String nomeFiltro = this.view.jTextFieldFiltroNome.getText();
        String cpfFiltro = this.view.jFormattedTextFieldFiltroCpf.getText();

        for (Cliente cliente : ClienteDAO.getInstance().getClientesBySimilarNomeOrCpf(nomeFiltro, cpfFiltro)) {
            this.view.jChoiceCliente.add(cliente.getNome());
        }
    }
}

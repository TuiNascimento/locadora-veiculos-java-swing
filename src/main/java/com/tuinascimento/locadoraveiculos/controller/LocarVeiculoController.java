package com.tuinascimento.locadoraveiculos.controller;

import com.tuinascimento.locadoraveiculos.model.cliente.Cliente;
import com.tuinascimento.locadoraveiculos.model.cliente.ClienteDAO;
import com.tuinascimento.locadoraveiculos.view.LocadoraVeiculosMainView;
import com.tuinascimento.locadoraveiculos.view.tablemodel.VeiculoDisponivelTableModel;

import java.util.Map;

public class LocarVeiculoController {

    private LocadoraVeiculosMainView view;

    public VeiculoDisponivelTableModel veiculoDisponivelTableModel;

    public LocarVeiculoController(LocadoraVeiculosMainView view) {
        this.view = view;
        this.veiculoDisponivelTableModel = new VeiculoDisponivelTableModel();
    }

    public void init() {
        populaChoiceClientes();

        this.view.jTextFieldFiltroNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtraChoiceClientes();
            }
        });

        this.view.jFormattedTextFieldFiltroCpf.addPropertyChangeListener(e -> filtraChoiceClientes());

        this.view.jButtonFiltrarVeiculoDisponivel.addActionListener(e -> filtraVeiculoDisponivel());

        this.view.jButtonLocar.addActionListener(e -> locarVeiculo());
    }

    private void locarVeiculo() {

    }

    private void filtraVeiculoDisponivel() {
        Map<String, Object> filter = Map.of(
                "tipo", this.view.jComboBoxTipoVeiculoFiltro.getSelectedItem(),
                "marca", this.view.jComboBoxMarcaFiltro.getSelectedItem(),
                "categoria", this.view.jComboBoxCategoriaFiltro.getSelectedItem()
        );
        this.veiculoDisponivelTableModel.setFilters(filter);
        this.veiculoDisponivelTableModel.fireTableDataChanged();
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

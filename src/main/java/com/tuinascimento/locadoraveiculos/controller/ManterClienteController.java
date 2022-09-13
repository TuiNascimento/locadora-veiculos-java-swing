package com.tuinascimento.locadoraveiculos.controller;

import com.tuinascimento.locadoraveiculos.model.cliente.Cliente;
import com.tuinascimento.locadoraveiculos.model.cliente.ClienteDAO;
import com.tuinascimento.locadoraveiculos.utils.CpfCnpjUtils;
import com.tuinascimento.locadoraveiculos.utils.StringUtils;
import com.tuinascimento.locadoraveiculos.view.LocadoraVeiculosMainView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ManterClienteController {

    private LocadoraVeiculosMainView view;

    public ClienteDAO dao;

    public ManterClienteController(LocadoraVeiculosMainView view) {
        this.view = view;
        this.dao = new ClienteDAO();
    }

    public void init() {
        this.view.botaoAdicionar.addActionListener(e -> adicionarCliente(e));
        this.view.botaoRemover.addActionListener(e -> removerListCliente());
        this.view.botaoAtualizar.addActionListener(e -> atualizarCliente(e));
        this.view.jTableClientes.getSelectionModel().addListSelectionListener(e -> atualizaValorCamposComClienteSelecionado());
    }

    public void adicionarCliente(ActionEvent evt) {
        String mensagemValidacao = validarAdicionarCliente(evt);
        if (!mensagemValidacao.isEmpty()) {
            JOptionPane.showMessageDialog(this.view, mensagemValidacao);
            return;
        }

        Cliente cliente = new Cliente(this.view.jTextFieldNome.getText(), this.view.jTextFieldRg.getText(), this.view.jFormattedTextFieldCpf.getText(), this.view.jTextFieldEndereco.getText());
        this.dao.adicionaCliente(cliente);

        this.view.limpaCampos();
    }

    private void removerListCliente() {
        int linhaAtual = this.view.jTableClientes.getSelectedRow();
        if (linhaAtual == -1) {
            JOptionPane.showMessageDialog(this.view, "Selecione um cliente para remover");
            return;
        }

        Object[] options = {"Sim", "Não"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(this.view,
                "Deseja remover o(s) cliente(s) selecionado(s)?",
                "Remover Cliente",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);

        if (opcaoSelecionada != JOptionPane.YES_OPTION) return;

        while (linhaAtual != -1) {
            this.dao.removeCliente(linhaAtual);

            linhaAtual = this.view.jTableClientes.getSelectedRow();
        }

        this.view.limpaCampos();
    }
    private void atualizarCliente(ActionEvent evt) {
        String mensagemValidacao = validarAtualizacaoClientes(evt);
        if (!mensagemValidacao.isEmpty()) {
            JOptionPane.showMessageDialog(this.view, mensagemValidacao);
            return;
        }

        int linhaAtual = this.view.jTableClientes.getSelectedRow();

        Cliente clienteAtualizado = new Cliente(this.view.jTextFieldNome.getText(), this.view.jTextFieldRg.getText(), this.view.jFormattedTextFieldCpf.getText(), this.view.jTextFieldEndereco.getText());
        this.dao.atualizaCliente(linhaAtual, clienteAtualizado);

        this.view.limpaCampos();
    }

    private String validarAdicionarCliente(ActionEvent evt) {
        String mensagemValidacao = "";

        mensagemValidacao += validaCamposObrigatorios();

        mensagemValidacao += validaClienteComMesmosDados(evt);

        return mensagemValidacao;
    }

    private String validarAtualizacaoClientes(ActionEvent evt) {
        String mensagemValidacao = "";

        if (this.view.jTableClientes.getSelectedRow() == -1) return "Selecione um cliente para atualizar";

        mensagemValidacao += validaCamposObrigatorios();

        int numeroLinhasSelecionadas = this.view.jTableClientes.getSelectedRowCount();
        if (numeroLinhasSelecionadas > 1) return "Não é possível atualizar mais de um cliente ao mesmo tempo";

        return mensagemValidacao;
    }

    private String validaCamposObrigatorios() {
        String mensagemValidacao = "";

        if (view.jTextFieldNome.getText().isEmpty()) {
            mensagemValidacao += "O campo nome é obrigatório. \n";
        }

        if (StringUtils.removeNonNumeric(view.jFormattedTextFieldCpf.getText()).isEmpty()) {
            mensagemValidacao += "O campo CPF é obrigatório. \n";
        }

        if (!CpfCnpjUtils.validaCpf(view.jFormattedTextFieldCpf.getText())) {
            mensagemValidacao += "O CPF informado é inválido. \n";
        }

        return mensagemValidacao;
    }

    private String validaClienteComMesmosDados(ActionEvent evt) {
        Cliente clienteComMesmosDados = this.dao.getClienteByUniqueFields(this.view.jFormattedTextFieldCpf.getText(), this.view.jTextFieldRg.getText(), this.view.jFormattedTextFieldCpf.getText());
        if (clienteComMesmosDados == null) return "";

        return "Já existe um cliente com os mesmos dados. \n";
    }
    public void atualizaValorCamposComClienteSelecionado() {
        int linhaSelecionada = this.view.jTableClientes.getSelectedRow();
        if (linhaSelecionada != -1) {
            Cliente clienteSelecionado = this.dao.getCliente(linhaSelecionada);
            this.view.jTextFieldNome.setText(clienteSelecionado.getNome());
            this.view.jTextFieldRg.setText(clienteSelecionado.getRg());
            this.view.jFormattedTextFieldCpf.setText(clienteSelecionado.getCpf());
            this.view.jTextFieldEndereco.setText(clienteSelecionado.getEndereco());
        }
    }
}

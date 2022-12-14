package com.tuinascimento.locadoraveiculos.controller;

import com.tuinascimento.locadoraveiculos.model.Locacao;
import com.tuinascimento.locadoraveiculos.model.automovel.Automovel;
import com.tuinascimento.locadoraveiculos.model.automovel.ModeloAutomovel;
import com.tuinascimento.locadoraveiculos.model.motocicleta.ModeloMotocicleta;
import com.tuinascimento.locadoraveiculos.model.motocicleta.Motocicleta;
import com.tuinascimento.locadoraveiculos.model.van.ModeloVan;
import com.tuinascimento.locadoraveiculos.model.van.Van;
import com.tuinascimento.locadoraveiculos.model.veiculo.Veiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.VeiculoDAO;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.CategoriaVeiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.EstadoVeiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.MarcaVeiculo;
import com.tuinascimento.locadoraveiculos.model.veiculo.enums.TipoVeiculo;
import com.tuinascimento.locadoraveiculos.utils.StringUtils;
import com.tuinascimento.locadoraveiculos.view.LocadoraVeiculosMainView;

import javax.swing.*;

public class AdicionarVeiculoController {

    private LocadoraVeiculosMainView view;

    public AdicionarVeiculoController(LocadoraVeiculosMainView view) {
        this.view = view;
    }

    public void init() {
        populaComboBoxModeloDeAcordoComTipoVeiculo();

        this.view.jComboBoxTipoVeiculo.addActionListener( e -> populaComboBoxModeloDeAcordoComTipoVeiculo() );
        this.view.jButtonAdicionarVeiculo.addActionListener(e -> adicionarVeiculo());
    }

    private void populaComboBoxModeloDeAcordoComTipoVeiculo() {
        TipoVeiculo tipoVeiculo = (TipoVeiculo) this.view.jComboBoxTipoVeiculo.getSelectedItem();
        JComboBox cbModelo = this.view.jComboBoxModelo;

        if (tipoVeiculo.isAutomovel()) {
            cbModelo.setModel(new DefaultComboBoxModel<>(ModeloAutomovel.values()));
        } else if (tipoVeiculo.isMotocicleta()) {
            cbModelo.setModel(new DefaultComboBoxModel<>(ModeloMotocicleta.values()));
        } else if (tipoVeiculo.isVan()) {
            cbModelo.setModel(new DefaultComboBoxModel<>(ModeloVan.values()));
        }
    }

    public void adicionarVeiculo() {
        String mensagemValidacao = validarAdicionarVeiculo();
        if (!mensagemValidacao.isEmpty()) {
            JOptionPane.showMessageDialog(this.view, mensagemValidacao);
            return;
        }

        Veiculo veiculo = buildVeiculoFromFields();
        VeiculoDAO.getInstance().save(veiculo);

        this.view.locarVeiculoController.veiculoDisponivelTableModel.fireTableDataChanged();

        limpaCampos();
    }

    private String validarAdicionarVeiculo() {
        String mensagemValidacao = "";

        Object placa = this.view.jFormattedTextFieldPlaca.getValue();
        if (placa == null) {
            mensagemValidacao += "O campo Placa ?? obrigat??rio \n";
        }

        if (this.view.jFormattedTextFieldValorDeCompra.getValue() == null) {
            mensagemValidacao += "O campo Valor de Compra ?? obrigat??rio \n";
        }

        if (this.view.jFormattedTextFieldAno.getValue() == null) {
            mensagemValidacao += "O campo Ano ?? obrigat??rio \n";
        }

        if (placa != null && VeiculoDAO.getInstance().findByPlaca(placa.toString()) != null) {
            mensagemValidacao += "J?? existe um ve??culo com essa placa \n";
        }

        return mensagemValidacao;
    }

    private Veiculo buildVeiculoFromFields() {
        TipoVeiculo tipoVeiculo = (TipoVeiculo) this.view.jComboBoxTipoVeiculo.getSelectedItem();
        MarcaVeiculo marca = (MarcaVeiculo) this.view.jComboBoxMarca.getSelectedItem();
        Locacao locacao = null;
        EstadoVeiculo estado = (EstadoVeiculo) this.view.jComboBoxEstado.getSelectedItem();
        CategoriaVeiculo categoria = (CategoriaVeiculo) this.view.jComboBoxCategoria.getSelectedItem();
        double valorDeCompra = StringUtils.convertToDouble(this.view.jFormattedTextFieldValorDeCompra.getText());
        String placa = this.view.jFormattedTextFieldPlaca.getText();
        int ano = Integer.parseInt(this.view.jFormattedTextFieldAno.getText());

        Veiculo veiculo;

        if (tipoVeiculo.isAutomovel()) {
            ModeloAutomovel modelo = (ModeloAutomovel) this.view.jComboBoxModelo.getSelectedItem();
            veiculo = new Automovel(modelo, marca, locacao, estado, categoria, valorDeCompra, placa, ano);
        } else if (tipoVeiculo.isMotocicleta()) {
            ModeloMotocicleta modelo = (ModeloMotocicleta) this.view.jComboBoxModelo.getSelectedItem();
            veiculo = new Motocicleta(modelo, marca, locacao, estado, categoria, valorDeCompra, placa, ano);
        } else if (tipoVeiculo.isVan()) {
            ModeloVan modelo = (ModeloVan) this.view.jComboBoxModelo.getSelectedItem();
            veiculo = new Van(modelo, marca, locacao, estado, categoria, valorDeCompra, placa, ano);
        } else {
            throw new UnsupportedOperationException("Tipo de ve??culo n??o suportado: " + tipoVeiculo.toString());
        }

        return veiculo;
    }

    private void limpaCampos() {
        this.view.jFormattedTextFieldValorDeCompra.setText("");
        this.view.jFormattedTextFieldPlaca.setText("");
        this.view.jFormattedTextFieldAno.setText("");
    }
}

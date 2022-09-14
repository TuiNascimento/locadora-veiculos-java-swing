package com.tuinascimento.locadoraveiculos.model.veiculo.enums;

public enum TipoVeiculo {
    AUTOMOVEL,
    MOTOCICLETA,
    VAN;

    public Boolean isAutomovel() {
        return TipoVeiculo.AUTOMOVEL == this;
    }

    public Boolean isMotocicleta() {
        return TipoVeiculo.MOTOCICLETA == this;
    }

    public Boolean isVan() {
        return TipoVeiculo.VAN == this;
    }
}

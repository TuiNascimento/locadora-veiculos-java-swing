package com.tuinascimento.locadoraveiculos.model.veiculo.enums;

public enum EstadoVeiculo {
    NOVO,
    LOCADO,
    DISPONIVEL,
    VENDIDO;

    public Boolean isLocado() {
        return this == LOCADO;
    }
}

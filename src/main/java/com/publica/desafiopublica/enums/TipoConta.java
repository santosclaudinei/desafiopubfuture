package com.publica.desafiopublica.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public enum TipoConta {

    @JsonProperty("Corrente")
    CONTA_CORRENTE("Conta Corrente"),

    @JsonProperty("Poupanca")
    CONTA_POUPANCA("Conta Poupanca");

    @Getter
    private final String value;

    TipoConta(String value) {
        this.value = value;
    }

}

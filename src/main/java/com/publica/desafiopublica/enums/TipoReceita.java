package com.publica.desafiopublica.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public enum TipoReceita {

    @JsonProperty("Salario")
    SALARIO("Salário"),

    @JsonProperty("Presente")
    PRESENTE("Presente"),

    @JsonProperty("Premio")
    PREMIO("Prêmio"),

    @JsonProperty("Outros")
    OUTROS("Outros");

    @Getter
    private final String value;

    TipoReceita(String value) {
        this.value = value;
    }

}
